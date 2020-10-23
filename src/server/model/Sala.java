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
import java.util.List;
import java.util.Set;

@NamedQueries({
      @NamedQuery(name="Sala.findAll",
         query="SELECT sala "+ 
               "FROM Sala sala"),
      @NamedQuery(name="Sala.findAllOpVt",
         query="SELECT sala.opVotacion "+ 
               "FROM Sala sala"),
      @NamedQuery(name="Sala.findById",
         query="SELECT sala "+ 
               "FROM Sala sala "+
               "WHERE sala.id= :sala_id"),
      @NamedQuery(name="Sala.findByNombre",
         query="SELECT sala "+ 
               "FROM Sala sala "+
               "WHERE UPPER(sala.nombre)= UPPER(:sala_nombre)"),
      @NamedQuery(name="Sala.findByUsername",
         query="SELECT sala "+ 
               "FROM Sala sala "+
               "WHERE sala.usuario.username = :username"),
      @NamedQuery(name="Sala.findByUserVotante",
         query="SELECT votante.sala "+ 
               "FROM Votante votante "+
               "WHERE votante.usuario.username = :username")
})

@Entity
public class Sala {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name="nombre",unique=true)
   private String nombre;

   private String contrasenia;

   @ManyToOne(optional=false,cascade=CascadeType.ALL) 
   @JoinColumn(name="USUARIO", nullable=false, updatable=false)
   private Usuario usuario;

   @OneToMany(orphanRemoval=true)
   @JoinColumn(name="Sala_ID") // join column is in table for Order
   private List<OPVotacion> opVotacion;


   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getContrasenia() {
      return this.contrasenia;
   }

   public void setContrasenia(String contrasenia) {
      this.contrasenia = contrasenia;
   }

   public Usuario getUsuario() { 
      return this.usuario; 
   }

   public void setUsuario(Usuario usuario) { 
      this.usuario = usuario;
   }

   public List getOpVotacion() 
   {
      return opVotacion;
   }

   public void setOpVotacion(List opVotacion) 
   {
      this.opVotacion = opVotacion;
   }

   @Override
   public boolean equals(Object obj){
      if(obj == this){
         return true;
      }
      if(obj == null || obj.getClass() != this.getClass()){
         return false;
      }

      Sala guest = (Sala)obj;
      return this.id == guest.getId();
   }
}
