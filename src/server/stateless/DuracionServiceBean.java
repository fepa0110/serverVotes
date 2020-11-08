package stateless;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;


import model.Sala;
import model.Duracion;

import stateless.DuracionService;

@Stateless
public class DuracionServiceBean implements DuracionService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;


    public EntityManager getEntityManager() {
        return em;
    } 

    public Duracion findById(Sala sala){    
        try {
            return getEntityManager()
                .createNamedQuery("Duracion.findById", Duracion.class)
                .setParameter("sala_id", sala.getId())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public Duracion create(Duracion duracion) {
        //usuario.setUsername(usuario.getUsername());
        em.persist(duracion);
        return duracion;
    }

    
    @Override
    public Duracion update(Duracion duracion) {
        em.merge(duracion);
        return duracion;
    }

    @Override
    public Duracion remove(Duracion duracion) {
        em.remove(duracion);
        return duracion;
    }

  

   

    
}
