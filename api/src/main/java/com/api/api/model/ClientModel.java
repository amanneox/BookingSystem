package com.api.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client_list")
public class ClientModel extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private  String number;

    private  String clientID;

    private  String clientDoc;

    private  String bookingID;

}
