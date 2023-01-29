package com.example.safar;

public class StatePlacesData {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String name;
    String url;
    public StatePlacesData()
    {

    }
    public StatePlacesData(String name,String url)
    {
        name=this.name;
        url=this.url;
    }
}
