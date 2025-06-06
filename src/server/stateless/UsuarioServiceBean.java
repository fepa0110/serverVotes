package stateless;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;

import model.Usuario;
import model.UbicacionUsuario;
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
    public List<Usuario> findAll() {
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findAll", Usuario.class)
                .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
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

        if(usuario.getUbicacion() != null){
            usuarioBuscado.setUbicacion(usuario.getUbicacion());
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
                .setParameter("username", usuario.getUsername())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario findEmailExists(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findEmailExists", Usuario.class)
                .setParameter("email", usuario.getCorreoElectronico())
                .getSingleResult();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario findByDni(Usuario usuario){
        try {
            return getEntityManager()
                .createNamedQuery("Usuario.findByDni", Usuario.class)
                .setParameter("dni", usuario.getDni())
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

    @Override
    public Usuario addUbicacion(Usuario usuario){
        UbicacionUsuario ubicacion = usuario.getUbicacion();
        usuario = this.findByUsername(usuario);

        if(usuario.getUbicacion() == null){
            usuario.setUbicacion(ubicacion);
            em.merge(usuario);
            return usuario;
        }
        else return null;
    }

    @Override
    public Collection<Usuario> search(String name) {
        return em.createQuery("SELECT usuario from Usuario usuario "+
                                "WHERE UPPER(usuario.username) "+ 
                                "LIKE CONCAT('%',UPPER(:usuario_username),'%')", Usuario.class)
            .setParameter("usuario_username", name).getResultList();
    }
}