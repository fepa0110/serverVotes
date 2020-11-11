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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;

import java.util.Set;
import java.util.Calendar;

import model.Usuario;

@Entity
public class UbicacionUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ubicacion_id")
    private int id;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @OneToOne(optional=false, mappedBy="ubicacion")
    private Usuario usuario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Usuario getUsuario() {
        return this.usuario; 
    }

}
