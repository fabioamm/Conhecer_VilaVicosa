package com.example.fbiomateus.conhecer_vilavicosa;

/**
 * Created by Fábio Mateus on 30/05/2017.
 */

public class Place {
    private int id;
    private String type;
    private String name;
    private String description;
    private String openHour;
    private String closeHour;
    private String contact;
    private String imgUrl;
    private String latitude;
    private String longitude;

    public Place(int id, String type, String name, String description, String openHour, String closeHour, String contact, String imgUrl, String latitude, String longitude) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.contact = contact;
        this.imgUrl = imgUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
