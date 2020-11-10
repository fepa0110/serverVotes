package stateless;

import java.util.List;

import model.Seguridad;
import model.Usuario;

public interface SeguridadService{
    public List<Seguridad> findById(Usuario usuario);
    public Seguridad find(int segu_id);
    public Seguridad create(Seguridad duracion);
    public Seguridad update(Seguridad duracion);
    public Seguridad remove(int id);   
}