package model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.Set;

@NamedQueries({
      @NamedQuery(name="Sala.findAll",
         query="SELECT sala "+ 
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
               "WHERE sala.usuario.username = :username")
})

@Entity
public class Sala {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String nombre;

   @ManyToOne(optional=false,cascade=CascadeType.ALL) 
   @JoinColumn(name="USUARIO", nullable=false, updatable=false)
   private Usuario usuario;

   @OneToMany(mappedBy = "sala", cascade=CascadeType.ALL)
   private List opVotacion; 

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
