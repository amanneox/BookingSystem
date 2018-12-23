package com.api.api.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game_list")
public class GameModel extends AuditModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "name")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Column(name = "description")
    private String description;

    @ElementCollection
    @JsonProperty("photos")
    private List<PhotoModel> photos;

    public String getName() {
        return name;
    }

    public List<PhotoModel> getPhotos() {
        return photos;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
