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

import stateless.OPVotacionService;

@Stateless
public class OPVotacionServiceBean implements OPVotacionService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public OPVotacion create(OPVotacion opVotacion){         
            em.persist(opVotacion);
            return opVotacion;       
    }

    @Override
    public OPVotacion update(OPVotacion opVotacion) {
        em.merge(opVotacion);
        return opVotacion;
    }

    @Override
    public void remove(int id) {
        
    }

}