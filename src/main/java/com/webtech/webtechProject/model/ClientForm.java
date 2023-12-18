package com.webtech.webtechProject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClientForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String targetGoal;
    private double currentWeight;
    //private
    private String email;
    private double height;
    private double targetWeight;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



}
