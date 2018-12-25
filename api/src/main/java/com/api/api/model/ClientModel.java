package com.api.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "client_list")
public class ClientModel extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotBlank
    @Column(unique=true)
    private  String bookingID;

    @NotBlank
    private String status;

    @NotBlank
    private String gatewayInfo;


    @NotBlank
    private  Long user_id;

    @NotBlank
    private  Long room_id;

    public Long getRoom_id() {
        return room_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public String getGatewayInfo() {
        return gatewayInfo;
    }

    public void setGatewayInfo(String gatewayInfo) {
        this.gatewayInfo = gatewayInfo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
