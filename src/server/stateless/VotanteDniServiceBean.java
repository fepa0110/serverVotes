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

import model.VotanteDni;
import model.Usuario;
import model.Sala;

import stateless.VotanteService;
import stateless.UsuarioService;
import stateless.SalaService;

@Stateless
public class VotanteDniServiceBean implements VotanteDniService {
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
    public VotanteDni create(VotanteDni votanteDni) {
        em.persist(votanteDni);
        return votanteDni;
    }

    @Override
    public Boolean estaAgregado(Usuario usuario, Sala sala){
        VotanteDni votanteBuscado;
        try {
            votanteBuscado = getEntityManager()
                .createNamedQuery("VotanteDni.findByDni", VotanteDni.class)
                .setParameter("dni", usuario.getDni())
                .setParameter("sala_id", sala.getId())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<VotanteDni> addVotantesByDni(List<Usuario> usuarios, Sala sala){
        sala = salaService.findById(sala);
        List<VotanteDni> votantesAgregados = new ArrayList<VotanteDni>();
        logger.info("Lista recibida: ");

        //Busco los usuarios completos
        for(Usuario usuario : usuarios){
                //Si no esta agregado a la sala entonces lo agrego
                if(!this.estaAgregado(usuario, sala)){
                    VotanteDni nuevoVotante = new VotanteDni();
                    nuevoVotante.setSala(sala);
                    nuevoVotante.setDni(usuario.getDni());
                    nuevoVotante.setVoto(false);
                    logger.info("Votante agregado");

                    votantesAgregados.add(nuevoVotante);
                    this.create(nuevoVotante);
                }
            }
        return votantesAgregados;
    }

    public List<VotanteDni> findBySala(Sala sala){
        try {
            return getEntityManager()
                .createNamedQuery("VotanteDni.findBySala", VotanteDni.class)
                .setParameter("sala_id", sala.getId())
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }
}