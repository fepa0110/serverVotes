package stateless;

import javax.ejb.EJB;
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
    public Usuario update(Usuario usuario) {
        //Traigo el usuario
        Usuario usuarioBuscado = this.findByUsername(usuario);

        //Si el usuario no existe 
        if(usuarioBuscado == null) return null;

        //Actualizo el usuario con los datos
        if(usuario.getNombre() != null && usuario.getNombre() != usuarioBuscado.getNombre()) {
            usuarioBuscado.setNombre(usuario.getNombre());
        }

        if(usuario.getApellido() != null && usuario.getApellido() != usuarioBuscado.getApellido() ) {
            usuarioBuscado.setApellido(usuario.getApellido());
        }

        if(usuario.getCorreoElectronico() != null && usuario.getCorreoElectronico() != usuarioBuscado.getCorreoElectronico() ) {
            usuarioBuscado.setCorreoElectronico(usuario.getCorreoElectronico());
        }

        if(usuario.getContrasenia() != null && usuario.getContrasenia() != usuarioBuscado.getContrasenia()){
            usuarioBuscado.setContrasenia(usuario.getContrasenia());
        } 

        //Actualizo el usuario en la base de datos
        em.merge(usuarioBuscado);
        return usuarioBuscado;
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
    public Usuario findByEmail(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", usuario.getCorreoElectronico())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario findByLogin(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findByLogin", Usuario.class)
                .setParameter("username", usuario.getUsername())
                .setParameter("password", usuario.getContrasenia())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario autenticarUsuario(Usuario usuario){
        Usuario usuarioPersistido = this.findByLogin(usuario);
        return usuarioPersistido;
    }
}