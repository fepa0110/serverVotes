package stateless;

import model.Duracion;
import model.Sala;

public interface DuracionService{
    public Duracion findById(Sala sala);
    public Duracion create(Duracion duracion);
    public Duracion update(Duracion duracion);
    public Duracion remove(Duracion duracion);   
}