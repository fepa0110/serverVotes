package model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.util.Set;

@NamedQueries({
      @NamedQuery(name="Seguridad.findAll",
         query="SELECT seguridad "+ 
               "FROM Seguridad seguridad"),
    @NamedQuery(name="Seguridad.find",
         query="SELECT seguridad "+ 
               "FROM Seguridad seguridad " + 
               "WHERE seguridad.id = :seguridad_id"),
      @NamedQuery(name="Seguridad.findById",
         query="SELECT seguridad "+ 
               "FROM Seguridad seguridad "+
               "WHERE seguridad.usuario.username = :usuario_username")
})

@Entity
public class Seguridad {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @ManyToOne(optional=false)
   @JoinColumn(name="USUARIO_ID")
   public Usuario usuario;

   private String modeloSmartphone;

   @Column(unique=true)
   private String idSmartPhone;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getModeloSmartphone() {
        return this.modeloSmartphone;
    }

    public void setModeloSmartphone(String modeloSmartphone) {
        this.modeloSmartphone = modeloSmartphone;
    }

    public String getIdSmartPhone() {
        return this.idSmartPhone;
    }

    public void setIdSmartPhone(String idSmartPhone) {
        this.idSmartPhone = idSmartPhone;
    }



}