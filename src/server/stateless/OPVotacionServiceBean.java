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
    public OPVotacion create(OPVotacion opVotacion, int sala_id){
            Query query = getEntityManager().createNativeQuery("INSERT INTO OPVOTACION (TITULO, DESCRIPCION, SALA_ID) VALUES ('"+opVotacion.getTitulo()+"', '"+opVotacion.getDescripcion()+"', "+sala_id+")");         
            query.executeUpdate();
            getEntityManager().getTransaction().commit();
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