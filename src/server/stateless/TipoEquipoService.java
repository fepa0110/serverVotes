package stateless;

import java.util.List;
import java.util.Calendar;
import java.util.Collection;

import model.TipoEquipo;

public interface TipoEquipoService{
    public List<TipoEquipo> findAll();
    public TipoEquipo findById(TipoEquipo tipoEquipo);
    //public List<TipoEquipo> findByProducto(Producto producto);
    //public List<TipoEquipo> findByTaller(Taller taller);
    public TipoEquipo create(TipoEquipo tipoEquipo);
    public TipoEquipo update(TipoEquipo tipoEquipo);
    public void remove(int id);   
    public Collection<TipoEquipo> search(String name);
    //public ResultsPage<TipoEquipo> findByPage(Integer page, Integer cantPerPage);
}