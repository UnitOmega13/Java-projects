package model;

import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String login;
    private String password;
    private String accessRole;

    public User(UUID id, String email, String login, String password, String accessRole) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.password = password;
        this.accessRole = accessRole;
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

    public UUID getId() {
        return id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(String accessRole) {
        this.accessRole = accessRole;
    }


}
