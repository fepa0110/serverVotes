package stateless;

import java.util.List;
import java.util.Calendar;
import java.util.Collection;

import model.Sala;
import model.Usuario;

public interface SalaService{
    public List<Sala> findAll();
    public Sala findById(Sala sala);
    public Sala create(Sala sala);
    public Sala update(Sala sala);
    public void remove(int id);   
    public Collection<Sala> search(String name);
    public Sala findByNombre(String nombre);
    public List<Sala> findByUsername(Usuario usuario);
}
