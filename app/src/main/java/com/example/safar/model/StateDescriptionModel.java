package com.example.safar.model;

import java.io.Serializable;

public class StateDescriptionModel implements Serializable {
    String climate;
    String description;
    String extras;
    String image;
    String location;
    String name;
    String type;
    String video;
    String code;
    String id;

    public StateDescriptionModel() {
    }

    public StateDescriptionModel(String climate, String description, String extras, String image,
                                 String location, String name, String type, String video, String id, String code) {
        this.climate = climate;
        this.description = description;
        this.extras = extras;
        this.image = image;
        this.location = location;
        this.name = name;
        this.type = type;
        this.video = video;
        this.id = id;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
