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
    @NamedQuery(name="VotanteDni.findAll",
        query="SELECT votanteDni "+ 
                "FROM VotanteDni votanteDni"),
    @NamedQuery(name="VotanteDni.findByDni",
        query="SELECT votanteDni "+ 
            "FROM VotanteDni votanteDni "+
            "WHERE votanteDni.dni = :dni "+
            "AND votanteDni.sala.id = :sala_id"),
    @NamedQuery(name="VotanteDni.findBySala",
        query="SELECT votanteDni "+ 
            "FROM VotanteDni votanteDni "+
            "WHERE votanteDni.sala.id = :sala_id")
})

@Entity
public class VotanteDni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    public String dni;

    @ManyToOne(optional=false) 
    @JoinColumn(name="SALA_ID")
    public Sala sala;

    @Column(name="Voto")
    public Boolean voto;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getDni() { 
        return dni; 
    }

    public void setDni(String dni) {
        this.dni = dni;
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
