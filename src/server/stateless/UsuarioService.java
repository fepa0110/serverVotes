package stateless;

import model.Usuario;

public interface UsuarioService{
    public Usuario create(Usuario usuario);
    public Usuario findByUsername(Usuario usuario);
    public Usuario autenticarUsuario(Usuario usuario);
}