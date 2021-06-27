package pt.iade.elchadb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PostalCode")
public class PostalCode {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Pc_ID")
    private int id;
    @Column(name="Pc_4D")
    private String code4D;
    @Column(name="Pc_3D")
    private String code3D;
    @Column(name="Pc_block")
    private String block;
    @Column(name="Pc_parish")
    private String parish;
    @Column(name="Pc_country")
    private String country;

    public PostalCode() {
    }

    public int getId() {
        return id;
    }

    public String getCode4D() {
        return code4D;
    }

    public String getCode3D() {
        return code3D;
    }

    public String getBlock() {
        return block;
    }

    public String getParish() {
        return parish;
    }

    public String getCountry() {
        return country;
    }
}