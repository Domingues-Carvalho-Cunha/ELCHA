package pt.iade.unimanagerdb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AppUser")
public class AppUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Us_ID")
    private int id;
    @Column(name="Us_firstName")
    private String firstName;
    @Column(name="Us_lastName")
    private String lastName;
    @Column(name="Us_gender")
    private String gender;
    @Column(name="Us_email")
    private String email;
    @Column(name="Us_dob")
    private String date;
    @Column(name="Us_points")
    private int points;
    @Column(name="Us_level")
    private String level;
    @Column(name="Us_gems")
    private int gems;
    @Column(name="Us_status")
    private boolean status;

    public AppUser() {
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getDate() {
        return date;
    }
    public int getPoints() {
        return points;
    }
    public String getLevel() {
        return level;
    }
    public int getGems() {
        return gems;
    }
    public boolean isStatus() {
        return status;
    }
}
