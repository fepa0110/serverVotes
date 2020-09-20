package stateless;

import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Collection;

import model.TipoEquipo;

import stateless.TipoEquipoService;

@Stateless
public class TipoEquipoServiceBean implements TipoEquipoService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public List<TipoEquipo> findAll() {
        try {
            return getEntityManager()
                .createNamedQuery("TipoEquipo.findAll", TipoEquipo.class)
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }


    public TipoEquipo findById(TipoEquipo tipoEquipo){    
        try {
            return getEntityManager()
                .createNamedQuery("TipoEquipo.findById", TipoEquipo.class)
                .setParameter("tipoEquipo_id", tipoEquipo.getId())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public TipoEquipo create(TipoEquipo tipoEquipo){
        em.persist(tipoEquipo);
        return tipoEquipo;
    }

    @Override
    public TipoEquipo update(TipoEquipo tipoEquipo) {
        em.merge(tipoEquipo);
        return tipoEquipo;
    }

    @Override
    public void remove(int id) {
        TipoEquipo tipoEquipo = new TipoEquipo();
        tipoEquipo.setId(id);
        tipoEquipo = findById(tipoEquipo);
        em.remove(tipoEquipo);
    }

    @Override
    public Collection<TipoEquipo> search(String name) {
        return em.createQuery("SELECT tipoEquipo from TipoEquipo tipoEquipo "+
                                "WHERE UPPER(tipoEquipo.nombre) "+ 
                                "LIKE CONCAT('%',UPPER(:tipoEquipo_nombre),'%')", TipoEquipo.class)
            .setParameter("tipoEquipo_nombre", name).getResultList();
    }
}