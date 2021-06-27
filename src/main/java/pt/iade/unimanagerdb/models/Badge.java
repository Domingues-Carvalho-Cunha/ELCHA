package pt.iade.unimanagerdb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Badge")
public class Badge {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Bad_id")
    private int id;
    @Column(name="Bad_name")
    private String name;
    @Column(name="Bad_description")
    private String description;
    @Column(name="Bad_type")
    private String type;
    
    public Badge() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
}

