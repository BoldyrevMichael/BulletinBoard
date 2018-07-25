package ru.boldyrev.ma.spring1.bulletinboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category extends AbstractEntity {

    public Category() {
    }

    @OneToMany(mappedBy = "category")
    private List<Ad> listOfAd;

    @Column(name = "name")
    private String name;

    public List<Ad> getListOfAd() {
        return listOfAd;
    }

    public void setListOfAd(List<Ad> listOfAd) {
        this.listOfAd = listOfAd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return '\n' + "Category{" + '\n' +
                "id='" + getId() + '\n' +
                "name='" + name + '\n' +
                '}' + '\n';
    }
}