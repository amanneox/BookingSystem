package com.api.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Table(name = "game_list")
public class GameModel extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    private String desc;

    @ElementCollection
    @JsonProperty("photos")
    private List<PhotoModel> photos;

    public String getName() {
        return name;
    }

    public List<PhotoModel> getPhotos() {
        return photos;
    }

    public String getDesc() {
        return desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotos(List<PhotoModel> photos) {
        this.photos = photos;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
