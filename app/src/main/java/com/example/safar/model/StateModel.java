package com.example.safar.model;

public class StateModel {

    String code;
    String name;

    public StateModel(){

    }

    public StateModel(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
