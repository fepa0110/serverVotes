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
      @NamedQuery(name="Sala.findAll",
         query="SELECT sala "+ 
               "FROM Sala sala"),
      @NamedQuery(name="Sala.findById",
         query="SELECT sala "+ 
               "FROM Sala sala "+
               "WHERE sala.id= :sala_id")
})

@Entity
public class Sala {

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

      Sala guest = (Sala)obj;
      return this.id == guest.getId();
   }
}
