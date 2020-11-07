package stateless;

import java.util.Collection;
import java.util.List;

import model.Usuario;
import stateless.dto.UsuarioComprensionDto;

public interface UsuarioFilterService{
    // public List<Usuario> findByCompresion(String desdeNombre, String desdeApellido);
    // public List<Usuario> findByCompresion(String desdeNombre, String hastaNombre, String desdeApellido, String hastaApellido);
    public List<Usuario> findByCompresion(UsuarioComprensionDto filtroComprension);
}