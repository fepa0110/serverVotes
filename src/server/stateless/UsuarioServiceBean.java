package stateless;

import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import model.Usuario;
import stateless.UsuarioService;

@Stateless
public class UsuarioServiceBean implements UsuarioService {
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    public EntityManager getEntityManager(){
        return em;
    }

    @Override
    public Usuario create(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }    
}