package com.example.rest;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "players")

@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "idplayers", nullable = false)
    private Integer idplayers;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(Integer idplayers) {
        this.idplayers = idplayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}