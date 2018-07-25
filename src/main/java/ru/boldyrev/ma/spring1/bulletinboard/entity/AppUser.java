package ru.boldyrev.ma.spring1.bulletinboard.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "app_user")
public class AppUser extends AbstractEntity {

    public AppUser() {
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "appUser")
    private List<Ad> listOfAd;

    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$", message = "{validation.client.login.pattern}")
    @Column(name = "login")
    private String login;

    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "{validation.client.firstname.pattern}")
    @Size(min = 2, max = 50, message = "{validation.client.firstname.size}")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[a-zA-z]+(['-][a-zA-Z]+)*", message = "{validation.client.lastname.pattern}")
    @Size(min = 2, max = 50, message = "{validation.client.lastname.size}")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = ".{8,}", message = "{validation.client.password.pattern}")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "{validation.client.email.pattern}")
    @Column(name = "email")
    private String email;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Ad> getListOfAd() {
        return listOfAd;
    }

    public void setListOfAd(List<Ad> listOfAd) {
        this.listOfAd = listOfAd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return '\n' + "AppUser{" + '\n' +
                "id='" + getId() + '\n' +
                "firstName='" + firstName + '\n' +
                "lastName='" + lastName + '\n' +
                "login='" + login + '\n' +
                "email='" + email + '\n' +
                '}' + '\n';
    }
}
