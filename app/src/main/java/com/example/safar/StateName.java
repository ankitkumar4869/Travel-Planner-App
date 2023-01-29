package com.example.safar;

public class StateName {
    private int imgid;
    private String place;

    StateName(int imgid,String place)
    {
        this.imgid=imgid;
        this.place=place;
    }

    public int getImgid() {
        return imgid;
    }

    public String getPlace() {
        return place;
    }

   /* public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public void setPlace(String place) {
        this.place = place;
    }*/
}

