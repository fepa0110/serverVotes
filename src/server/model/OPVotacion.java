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
import java.util.Set;

@NamedQueries({
      @NamedQuery(name="OPVotacion.findAll",
         query="SELECT OPVotacion "+ 
               "FROM OPVotacion OPVotacion"),
      @NamedQuery(name="OPVotacion.findById",
         query="SELECT OPVotacion "+ 
               "FROM OPVotacion OPVotacion "+
               "WHERE OPVotacion.id= :OPVotacion_id")
})

@Entity
public class OPVotacion {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String titulo;
   private String descripcion;

//   @ManyToOne(optional=false) 
//   @JoinColumn(name="Sala_ID", nullable=false, updatable=false)
//   private Sala sala;

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDescripcion() { 
      return this.descripcion; 
   }

   public void setDescripcion(String descripcion) { 
      this.descripcion = descripcion;
   }

   public Sala getSala() { 
      return this.sala; 
   }

   public void setSala(Sala sala) { 
      this.sala = sala;
   }

   @Override
   public boolean equals(Object obj){
      if(obj == this){
         return true;
      }
      if(obj == null || obj.getClass() != this.getClass()){
         return false;
      }

      OPVotacion guest = (OPVotacion)obj;
      return this.id == guest.getId();
   }
}
