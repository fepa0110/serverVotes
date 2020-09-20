package model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@NamedQueries({
      @NamedQuery(name="TipoEquipo.findAll",
         query="SELECT tequipo "+ 
               "FROM TipoEquipo tequipo"),
      @NamedQuery(name="TipoEquipo.findById",
         query="SELECT tequipo "+ 
               "FROM TipoEquipo tequipo "+
               "WHERE tequipo.id= :tipoEquipo_id"),
})

@Entity
public class TipoEquipo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String nombre;

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

   @Override
   public boolean equals(Object obj){
      if(obj == this){
         return true;
      }
      if(obj == null || obj.getClass() != this.getClass()){
         return false;
      }

      TipoEquipo guest = (TipoEquipo)obj;
      return this.id == guest.getId();
   }
}
