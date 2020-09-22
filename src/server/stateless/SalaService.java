package stateless;

import java.util.List;
import java.util.Calendar;
import java.util.Collection;

import model.Sala;

public interface SalaService{
    public List<Sala> findAll();
    public Sala findById(Sala sala);
    //public List<Sala> findByProducto(Producto producto);
    //public List<Sala> findByTaller(Taller taller);
    public Sala create(Sala sala);
    public Sala update(Sala sala);
    public void remove(int id);   
    public Collection<Sala> search(String name);
    //public ResultsPage<TipoEquipo> findByPage(Integer page, Integer cantPerPage);
}