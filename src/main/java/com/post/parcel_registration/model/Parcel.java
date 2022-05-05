package com.post.parcel_registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parcel {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int waight;
    private long idFrom;
    private long idTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaight() {
        return waight;
    }

    public void setWaight(int waight) {
        this.waight = waight;
    }

    public long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(long idFrom) {
        this.idFrom = idFrom;
    }

    public long getIdTo() {
        return idTo;
    }

    public void setIdTo(long idTo) {
        this.idTo = idTo;
    }

    public Parcel() {
    }

    public Parcel(long id, String name, int waight, long idFrom, long idTo) {
        this.id = id;
        this.name = name;
        this.waight = waight;
        this.idFrom = idFrom;
        this.idTo = idTo;
    }
}
