package model;

import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String login;
    private String password;

    public User(UUID id, String login,String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
