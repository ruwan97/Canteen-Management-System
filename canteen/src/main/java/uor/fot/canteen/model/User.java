package uor.fot.canteen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {
    @Id
    private String user_id;

    private String user_name;
    private String user_email;
    private String user_password;
    private Integer user_role;
    private Integer user_contact;
//    @Lob
//    @Column(columnDefinition = "BLOB")
    private String user_image;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_role() {
        return user_role;
    }

    public void setUser_role(Integer user_role) {
        this.user_role = user_role;
    }

    public Integer getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(Integer user_contact) {
        this.user_contact = user_contact;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }
}
