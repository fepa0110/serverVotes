package model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;

import java.util.Set;
import java.util.Calendar;


import model.Sala;
@NamedQueries({
    @NamedQuery(name="Duracion.findById",
         query="SELECT duracion "+ 
               "FROM Duracion duracion "+
               "WHERE duracion.sala.id= :sala_id"),

})



@Entity
public class Duracion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    private String hora;
    
    @OneToOne(optional=false) 
    @JoinColumn(name="SALA_ID")
    public Sala sala;
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


  
}