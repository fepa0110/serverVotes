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
        //usuario.setUsername(usuario.getUsername());
        em.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario findByUsername(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findByUsername", Usuario.class)
                .setParameter("username", usuario.getUsername())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario autenticarUsuario(Usuario usuario){
        Usuario usuarioPersistido = this.findByUsername(usuario);

        //Si el usuario existe
        if(usuario != null){
            int validezContraseña = usuario.getContrasenia()
                .compareToIgnoreCase(usuarioPersistido.getContrasenia());
            
            //si la contraseña es valida
            if(validezContraseña == 0){
                usuarioPersistido.setContrasenia(null);
                return usuarioPersistido; //Retorno la informacion de usuario
            }
            else return null;
        }
        else return null;
    }
}