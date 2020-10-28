package stateless;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import model.Votante;
import model.Usuario;
import model.Sala;

import stateless.VotanteService;
import stateless.UsuarioService;
import stateless.SalaService;

@Stateless
public class VotanteServiceBean implements VotanteService {
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    @EJB
    private UsuarioService usuarioService;

    @EJB
    private SalaService salaService;

    public Logger logger = Logger.getLogger(getClass().getName());

    public EntityManager getEntityManager(){
        return em;
    }

    @Override
    public Votante create(Votante votante) {
        em.persist(votante);
        return votante;
    }

    @Override
    public Votante remove(Votante votante) {
        em.remove(votante);
        return votante;
    }

    @Override
    public Boolean estaAgregado(Usuario usuario, Sala sala){
        Votante votanteBuscado;
        try {
            votanteBuscado = getEntityManager()
                .createNamedQuery("Votante.findByUsername", Votante.class)
                .setParameter("usuario_id", usuario.getId())
                .setParameter("sala_id", sala.getId())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Votante> addVotantesByUsername(List<Usuario> usuarios, Sala sala){
        sala = salaService.findById(sala);
        List<Votante> votantesAgregados = new ArrayList<Votante>();
        logger.info("Lista recibida: ");

        //Busco los usuarios completos
        for(Usuario usuario : usuarios){
            Usuario findUsuario = usuarioService.findByUsername(usuario);
            logger.info("Usuario"+findUsuario.getUsername()+": ");

            //Si el usuario existe
            if(findUsuario != null){
                logger.info("Usuario"+findUsuario.getUsername()+" EXISTE: ");
                //Si no esta agregado a la sala entonces lo agrego
                if(!this.estaAgregado(findUsuario, sala)){
                    Votante nuevoVotante = new Votante();
                    nuevoVotante.setSala(sala);
                    nuevoVotante.setUsuario(findUsuario);
                    nuevoVotante.setVoto(false);
                    logger.info("Votante agregado");

                    votantesAgregados.add(nuevoVotante);
                    this.create(nuevoVotante);
                }
            }
        }

        return votantesAgregados;
    }

    public Votante findByVotante(Sala sala, Usuario usuario){
        try {
            return getEntityManager()
            .createNamedQuery("Votante.findByUsername", Votante.class)
            .setParameter("usuario_id", usuario.getId())
            .setParameter("sala_id", sala.getId())
            .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Votante> findBySala(Sala sala){
        try {
            return getEntityManager()
            .createNamedQuery("Votante.findBySala", Votante.class)
            .setParameter("sala_id", sala.getId())
            .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Votante update(Votante votante) {
        em.merge(votante);
        return votante;
    }
}