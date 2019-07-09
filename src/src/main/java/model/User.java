package model;

import javax.persistence.Table;
import javax.persistence.Entity;

public class User {

    private Integer id;
    private String email;
    private String login;
    private String password;

    public User(String login,String email, String password) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
