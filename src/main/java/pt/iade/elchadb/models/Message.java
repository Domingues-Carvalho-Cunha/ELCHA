package pt.iade.unimanagerdb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="Mess_ID")
    private int id;
    @Column(name="Mess_text")
    private String text;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
