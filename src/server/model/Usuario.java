package model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Set;
import java.util.Calendar;

import model.Sala;

@NamedQueries({
    @NamedQuery(name="Usuario.findAll",
        query="SELECT usuario "+ 
                "FROM Usuario usuario"),
    @NamedQuery(name="Usuario.findByUsername",
        query="SELECT usuario "+ 
            "FROM Usuario usuario "+
            "WHERE UPPER(usuario.username) LIKE UPPER(:username)"),
    @NamedQuery(name="Usuario.findByEmail",
        query="SELECT usuario "+ 
            "FROM Usuario usuario "+
            "WHERE UPPER(usuario.correoElectronico) = UPPER(:email) "+
            "AND UPPER(usuario.username) != UPPER(:username)"),
    @NamedQuery(name="Usuario.findByDni",
        query="SELECT usuario "+ 
                "FROM Usuario usuario "+
                "WHERE UPPER(usuario.dni) LIKE UPPER(:dni)"),
    @NamedQuery(name="Usuario.findByLogin",
        query="SELECT usuario "+ 
            "FROM Usuario usuario "+
            "WHERE UPPER(usuario.username) LIKE UPPER(:username) "+
            "AND usuario.contrasenia LIKE :password")

})

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;

    @Column(name="username",unique=true)
    private String username;

    private String nombre;
    private String apellido;

    @Column(name="correoElectronico",unique=true)
    private String correoElectronico;
    
    private String contrasenia;

    @Column(name="dni",unique=true)
    private String dni;

    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre(){
        return this.nombre;
        
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico(){
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia(){
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Calendar getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }



    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Usuario guest = (Usuario)obj;
        return this.id == guest.getId();
    }
}
