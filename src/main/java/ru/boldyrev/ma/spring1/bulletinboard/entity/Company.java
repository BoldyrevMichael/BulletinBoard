package ru.boldyrev.ma.spring1.bulletinboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company extends AbstractEntity {

    public Company() {
    }

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Ad> listOfAd;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Ad> getListOfAd() {
        return listOfAd;
    }

    public void setListOfAd(List<Ad> listOfAd) {
        this.listOfAd = listOfAd;
    }

    @Override
    public String toString() {
        return '\n' + "Company{" + '\n' +
                "id='" + getId() + '\n' +
                "name='" + name + '\n' +
                "description='" + description + '\n' +
                "address='" + address + '\n' +
                '}' + '\n';
    }
}