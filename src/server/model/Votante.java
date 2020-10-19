package model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Set;
import java.util.Calendar;

import model.Sala;
import model.Usuario;

@NamedQueries({
    @NamedQuery(name="Votante.findAll",
        query="SELECT votante "+ 
                "FROM Votante votante"),
    @NamedQuery(name="Votante.findByUsername",
        query="SELECT votante "+ 
            "FROM Votante votante "+
            "WHERE votante.usuario.id = :usuario_id "+
            "AND votante.sala.id = :sala_id"),
    @NamedQuery(name="Votante.findBySala",
        query="SELECT votante "+ 
            "FROM Votante votante "+
            "WHERE votante.sala.id = :sala_id")
})

@Entity
public class Votante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USUARIO_ID",unique=true)
    public Usuario usuario;

    @ManyToOne(optional=false) 
    @JoinColumn(name="SALA_ID",unique=true)
    public Sala sala;

    @Column(name="Voto")
    public Boolean voto;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public Usuario getUsuario() { 
        return usuario; 
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Boolean getVoto() {
        return this.voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

}
