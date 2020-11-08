package stateless;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Collection;

import model.Sala;
import model.EstadoSala;
import model.Usuario;
import model.OPVotacion;
import model.Votante;
import model.Duracion;
import model.VotanteDni;

import stateless.SalaService;
import stateless.DuracionService;


@Stateless
public class SalaServiceBean implements SalaService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    @EJB
    private UsuarioService usuarioService;

    @EJB
    private VotanteService votanteService;

    @EJB
    private VotanteDniService votanteDniService;

     @EJB
    private DuracionService duracionService;

    public EntityManager getEntityManager() {
        return em;
    }

    public List<Sala> findAll() {
        try {
            return getEntityManager()
                .createNamedQuery("Sala.findAll", Sala.class)
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Sala> findAllOpVt() {
        try {
            return getEntityManager()
                .createNamedQuery("Sala.findAllOpVt", Sala.class)
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    public Sala findById(Sala sala){    
        try {
            return getEntityManager()
                .createNamedQuery("Sala.findById", Sala.class)
                .setParameter("sala_id", sala.getId())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Sala> findByUserVotante(Usuario usuario){
                try {
            return getEntityManager()
                .createNamedQuery("Sala.findByUserVotante", Sala.class)
                .setParameter("username", usuario.getUsername())
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Sala> findByUserVotanteDni(Usuario usuario){
                try {
            return getEntityManager()
                .createNamedQuery("Sala.findByUserVotanteDni", Sala.class)
                .setParameter("dni", usuario.getDni())
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Sala create(Sala sala, Usuario usuario){
        if(findByNombre(sala.getNombre()) == null){
            usuario = usuarioService.findByUsername(usuario);
            sala.setUsuario(usuario);

            sala.setEstado(EstadoSala.PENDIENTE);

            em.persist(sala);
            return sala;
        }
        else return null;
    }

    @Override
    public Sala update(Sala sala) {
        em.merge(sala);
        return sala;
    }

    @Override
    public void remove(int id) {
        Sala sala = new Sala();
        sala.setId(id);
        sala = findById(sala);

        
        List<Votante> votantes = votanteService.findBySala(sala);
        if(votantes != null){

            for(Votante votante : votantes){
                votanteService.remove(votante);
            }
        }

        List<VotanteDni> votantesDni = votanteDniService.findBySala(sala);
        if(votantesDni != null){

            for(VotanteDni votanteDni : votantesDni){
                votanteDniService.remove(votanteDni);
            }
        }

        Duracion duracion = duracionService.findById(sala);
        if(duracion != null){
            duracionService.remove(duracion);            
        }
        

        em.remove(sala);
    }

    @Override
    public Sala findByNombre(String nombre){
        try {
            return getEntityManager()
                .createNamedQuery("Sala.findByNombre", Sala.class)
                .setParameter("sala_nombre", nombre)
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Sala> findByUsername(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Sala.findByUsername", Sala.class)
                .setParameter("username", usuario.getUsername())
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Collection<Sala> search(String name) {
        return em.createQuery("SELECT sala from Sala sala "+
                                "WHERE UPPER(sala.nombre) "+ 
                                "LIKE CONCAT('%',UPPER(:sala_nombre),'%')", Sala.class)
            .setParameter("sala_nombre", name).getResultList();
    }

    @Override
    public Sala finalizar(Sala sala){
        sala = this.findById(sala);
        sala.setEstado(EstadoSala.FINALIZADA);

        em.merge(sala);
        return sala;
    }
}
