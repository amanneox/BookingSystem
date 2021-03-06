package com.api.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "room_list")
public class RoomModel extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String status;

    @NotBlank
    private int count;

    @NotBlank
    private  int size;

    @NotBlank

    private float price;

    @NotBlank
    private String description;

    @NotBlank
    @Column(unique=true)
    private String room_no;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GameModel game;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public float getPrice() {
        return price;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
