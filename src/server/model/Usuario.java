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
    private int id;

    private String username;

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
