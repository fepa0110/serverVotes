package stateless;

import java.util.List;
import java.util.Calendar;
import java.util.Collection;

import model.Sala;
import model.Usuario;
import model.OPVotacion;

public interface SalaService{
    public List<Sala> findAll();
    public List<Sala> findAllOpVt();
    public Sala findById(Sala sala);
    public Sala create(Sala sala, Usuario usuario);
    public Sala update(Sala sala);
    public void remove(int id);   
    public Collection<Sala> search(String name);
    public Sala findByNombre(String nombre);
    public List<Sala> findByUsername(Usuario usuario);
}
