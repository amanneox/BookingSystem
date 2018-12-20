package com.api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class RoomModel extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String status;

    @NotBlank
    private float price;

    @NotBlank
    private String desc;

    @NotBlank
    private String room_no;

    @ElementCollection
    @JsonProperty("photos")
    private List<PhotoModel> photos;

    public String getDesc() {
        return desc;
    }

    public Long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public List<PhotoModel> getPhotos() {
        return photos;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhotos(List<PhotoModel> photos) {
        this.photos = photos;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
