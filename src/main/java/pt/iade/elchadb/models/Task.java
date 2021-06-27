package pt.iade.elchadb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Task_id")
    private int id;
    @Column(name="Task_name")
    private String name;
    @Column(name="Task_description")
    private String description;
    @Column(name="Task_points")
    private int points;
    @Column(name="Task_category")
    private String category;
    @Column(name="Task_gems")
    private String gems;

    public Task() {
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
    public int getPoints() {
        return points;
    }
    public String getCategory() {
        return category;
    }
    public String getGems() {
        return gems;
    }
}