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
import stateless.UsuarioFilterService;
import stateless.dto.UsuarioComprensionDto;

@Stateless
public class UsuarioFilterServiceBean implements UsuarioFilterService {
    @PersistenceContext(unitName = "mrplite")
    protected EntityManager em;

    public EntityManager getEntityManager(){
        return em;
    }

/*     @Override
    public List<Usuario> findByCompresion(String desdeNombre, String hastaNombre, 
                String desdeApellido, String hastaApellido){
        try {
            return em.createQuery("SELECT usuario "+
                                "FROM Usuario usuario "+
                                "WHERE (UPPER(usuario.nombre) BETWEEN UPPER(:nombre_desde) "+ 
                                "AND UPPER(:nombre_hasta)) "+
                                "AND (UPPER(usuario.apellido) BETWEEN UPPER(:apellido_desde) "+
                                "AND UPPER(:apellido_hasta)) "+
                                "ORDER BY usuario.nombre ASC", Usuario.class)
            .setParameter("nombre_desde", desdeNombre)
            .setParameter("nombre_hasta", hastaNombre)
            .setParameter("apellido_hasta", hastaApellido)
            .setParameter("apellido_desde", desdeApellido)
            .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    } */

    @Override
    public List<Usuario> findByCompresion(UsuarioComprensionDto filtroComprension){
        try {
            if(filtroComprension.getDesdeNombre() == null || filtroComprension.getDesdeNombre().isEmpty()){
                filtroComprension.setDesdeNombre("A") ;
            }
            if(filtroComprension.getHastaNombre() == null || filtroComprension.getHastaNombre().isEmpty()){
                filtroComprension.setHastaNombre("Z");
            }
            if(filtroComprension.getDesdeApellido() == null || filtroComprension.getDesdeApellido().isEmpty()){
                filtroComprension.setDesdeApellido("A");
            }
            if(filtroComprension.getHastaApellido() == null || filtroComprension.getHastaApellido().isEmpty()){
                filtroComprension.setHastaApellido("Z");
            }

            return em.createQuery("SELECT usuario "+
                                "FROM Usuario usuario "+
                                "WHERE (UPPER(usuario.nombre) BETWEEN UPPER(:nombre_desde) "+ 
                                "AND UPPER(:nombre_hasta)) "+
                                "AND (UPPER(usuario.apellido) BETWEEN UPPER(:apellido_desde) "+
                                "AND UPPER(:apellido_hasta)) "+
                                "ORDER BY usuario.nombre ASC", Usuario.class)
            .setParameter("nombre_desde", filtroComprension.getDesdeNombre())
            .setParameter("nombre_hasta", filtroComprension.getHastaNombre())
            .setParameter("apellido_desde", filtroComprension.getDesdeApellido())
            .setParameter("apellido_hasta", filtroComprension.getHastaApellido())
            .getResultList();
        } 
        catch (NoResultException e) {
            return null;
        }
    }

/*     @Override
    public Collection<Usuario> search(String name) {
        return em.createQuery("SELECT usuario from Usuario usuario "+
                                "WHERE UPPER(usuario.username) "+ 
                                "LIKE CONCAT('%',UPPER(:usuario_username),'%')", Usuario.class)
            .setParameter("usuario_username", name).getResultList();
    } */
}