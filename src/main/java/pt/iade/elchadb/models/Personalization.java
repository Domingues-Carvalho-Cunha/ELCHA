package pt.iade.elchadb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Personalization")
public class Personalization {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Per_id")
    private int id;
    @Column(name="Per_name")
    private String name;
    @Column(name="Per_type")
    private String type;
    @Column(name="Per_gems")
    private int gems;

    public Personalization() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getGems() {
        return gems;
    }  
}

