package pt.iade.elchadb.models.views;

import java.sql.Date;

public interface UserView {
    int getId();
    String getFirstName();
    String getLastName();
    String getGender();
    Date getDateOfBirth();
    int getPoints();
    String getLevel();
    int getGems();
}