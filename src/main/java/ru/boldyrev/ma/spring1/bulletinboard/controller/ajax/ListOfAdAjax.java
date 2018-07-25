package ru.boldyrev.ma.spring1.bulletinboard.controller.ajax;

import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;

import java.util.List;

public class ListOfAdAjax {

    List<Ad> listOfAd;

    public List<Ad> getListOfAd() {
        return listOfAd;
    }

    public void setListOfAd(List<Ad> listOfAd) {
        this.listOfAd = listOfAd;
    }
}
