package stateless;

import java.util.List;
import java.util.Calendar;
import java.util.Collection;

import model.OPVotacion;

public interface OPVotacionService {
    
    public OPVotacion create(OPVotacion opVotacion, int sala_id);
    public OPVotacion update(OPVotacion opVotacion);
    public void remove(int id);   
    public OPVotacion findById(int id);

}