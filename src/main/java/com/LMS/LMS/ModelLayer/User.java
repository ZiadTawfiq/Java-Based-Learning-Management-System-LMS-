package com.LMS.LMS.ModelLayer;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID ;
    private String UserName ;
    @Column(nullable = false, unique = true)
    private String Email;
    private String Password ;
    @Enumerated(EnumType.STRING)

    private Role role ;

    public User(int ID, String userName, String email, String password, Role role) {
        this.ID = ID;
        UserName = userName;
        Email = email;
        Password = password;
        this.role = role;
    }

    public User() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
