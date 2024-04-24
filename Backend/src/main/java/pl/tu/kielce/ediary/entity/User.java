package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "emailAddress")
    private String emailAddress ;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User(long id, String username, String password, String role) {
        this.id = id;
        this.emailAddress  = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public User(String emailAddress, String password, String role) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
