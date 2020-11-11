package stateless;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.ArrayList;
import model.Usuario;
import model.Seguridad;

import stateless.SeguridadService;

@Stateless
public class SeguridadServiceBean implements SeguridadService{
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;


    public EntityManager getEntityManager() {
        return em;
    } 

    public List<Seguridad> findById(Usuario usuario){    
        try {
            return getEntityManager()
                .createNamedQuery("Seguridad.findById", Seguridad.class)
                .setParameter("usuario_username", usuario.getUsername())
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    public Seguridad find(int segu_id){    
        try {
            return getEntityManager()
                .createNamedQuery("Seguridad.find", Seguridad.class)
                .setParameter("seguridad_id", segu_id)
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public Seguridad create(Seguridad seguridad) {
        List<Seguridad> segu = findById(seguridad.getUsuario());
        for (int i=0; i<segu.size(); i++){
            if(segu.get(i).getIdSmartPhone().equals(seguridad.getIdSmartPhone())){
                return null;
            }
        }
        em.persist(seguridad);
        return seguridad;
    }

    
    @Override
    public Seguridad update(Seguridad seguridad) {
        em.merge(seguridad);
        return seguridad;
    }

    @Override
    public Seguridad remove(int id) {
        Seguridad seguridad = find(id);
        em.remove(seguridad);
        return seguridad;
    }

}
