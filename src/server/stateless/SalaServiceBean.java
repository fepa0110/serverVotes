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
        em.persist(sala);
        return sala;
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
    public Collection<Sala> search(String name) {
        return em.createQuery("SELECT sala from Sala sala "+
                                "WHERE UPPER(sala.nombre) "+ 
                                "LIKE CONCAT('%',UPPER(:sala_nombre),'%')", Sala.class)
            .setParameter("sala_nombre", name).getResultList();
    }
}