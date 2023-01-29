package com.example.safar.model;

public class StateListModel {
    String name;
    String image;
    String code;

    public StateListModel(){

    }

    public StateListModel(String name, String image, String code){
        this.name = name;
        this.image = image;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}