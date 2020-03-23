package com.mak.clockin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Clockin {

    @Id
    @GeneratedValue
    private int id;
    private Instant heure;
    private int userId;

    public int getId() {
        return id;
    }

    public Instant getHeure() {
        return heure;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeure(Instant heure) {
        this.heure = heure;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Clockin{" +
                "id=" + id +
                ", heure=" + heure +
                ", userId=" + userId +
                '}';
    }
}
