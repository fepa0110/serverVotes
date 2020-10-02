package stateless;

import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Collection;

import model.Sala;
import model.Usuario;
import model.OPVotacion;

import stateless.SalaService;

@Stateless
public class SalaServiceBean implements SalaService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

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
    public Sala create(Sala sala){
        if(findByNombre(sala.getNombre()) == null){
            
            //!USUARIO HARDCODEADO
            Usuario usuarioHardcodeado = new Usuario();
            usuarioHardcodeado.setId(1);
            usuarioHardcodeado.setUsername("Hardcodeado");
            sala.setUsuario(usuarioHardcodeado);

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
}
