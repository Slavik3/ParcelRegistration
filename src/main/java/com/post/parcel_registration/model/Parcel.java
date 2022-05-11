package com.post.parcel_registration.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Parcel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int waight;
    private long idFrom;
    private long idTo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sender sender;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipient recipient;

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

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Parcel() {
    }

    public Parcel(Long id, String name, int waight, long idFrom, long idTo, Sender sender, Recipient recipient) {
        this.id = id;
        this.name = name;
        this.waight = waight;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.sender = sender;
        this.recipient = recipient;
    }
}
