package stateless;

import java.util.List;

import model.Votante;
import model.Usuario;
import model.Sala;

public interface VotanteService{
    public Votante create(Votante votante);
    public Votante remove(Votante votante);
    public List<Votante> addVotantesByUsername(List<Usuario> usuarios, Sala sala);
    public Boolean estaAgregado(Usuario usuario, Sala sala);
    public Votante update(Votante usuario);
    public Votante findByVotante(Sala sala, Usuario usuario);
    public List<Votante> findBySala(Sala sala);
}