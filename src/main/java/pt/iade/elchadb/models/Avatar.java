package pt.iade.elchadb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Avatar")
public class Avatar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Ava_id")
    private int id;
    @Column(name="Ava_nickname")
    private String name;
    
    public Avatar() {
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}

