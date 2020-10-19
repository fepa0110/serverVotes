package stateless;

import model.Usuario;

public interface UsuarioService{
    public Usuario create(Usuario usuario);
    public Usuario findByUsername(Usuario usuario);
    public Usuario findByEmail(Usuario usuario);
    public Usuario findByDni(Usuario usuario);
    public Usuario findByLogin(Usuario usuario);
    public Usuario autenticarUsuario(Usuario usuario);
    public Usuario update(Usuario usuario);
}