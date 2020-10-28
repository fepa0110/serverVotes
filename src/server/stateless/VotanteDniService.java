package stateless;

import java.util.List;

import model.VotanteDni;
import model.Usuario;
import model.Sala;

public interface VotanteDniService{
    public VotanteDni create(VotanteDni votanteDni);
    public VotanteDni remove(VotanteDni votanteDni);
    public List<VotanteDni> addVotantesByDni(List<Usuario> usuariosDni, Sala sala);
    public Boolean estaAgregado(Usuario usuario, Sala sala);
    public VotanteDni update(VotanteDni votanteDni);
    public VotanteDni findByVotante(Sala sala, Usuario usuario);
    public List<VotanteDni> findBySala(Sala sala);
}