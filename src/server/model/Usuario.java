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
    @NamedQuery(name="Usuario.findById",
        query="SELECT usuario "+ 
            "FROM Usuario usuario "+
            "WHERE usuario.id= :usuario_id"),
    @NamedQuery(name="Usuario.findByUsername",
        query="SELECT usuario "+ 
            "FROM Usuario usuario "+
            "WHERE UPPER(usuario.username)= UPPER(:usuario_username)")
    
})

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;

    private String username;
    private String nombre;
    private String apellido;
    private String correElectronico;
    private String contrasenia;
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
        return nombre;
        
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico(){
        return correElectronico;
    }

    public void setCorreoElectronico(String correElectronico) {
        this.correElectronico = correElectronico;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Calendar getFechaNacimiento(){
        return fechaNacimiento;
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
