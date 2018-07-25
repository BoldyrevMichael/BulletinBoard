package ru.boldyrev.ma.spring1.bulletinboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role extends AbstractEntity {

    public Role() {
    }

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<AppUser> listOfAppUser;

    @Column(name = "name")
    private String name;

    public List<AppUser> getListOfAppUser() {
        return listOfAppUser;
    }

    public void setListOfAppUser(List<AppUser> listOfAppUser) {
        this.listOfAppUser = listOfAppUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return '\n' + "Role{" + '\n' +
                "id='" + getId() + '\n' +
                "name='" + name + '\n' +
                '}' + '\n';
    }
}
