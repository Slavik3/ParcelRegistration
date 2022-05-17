package com.post.parcel_registration.dto;

public class ParcelDTO {
    private Long id;
    private String name;
    private int weight;
    private long idFrom;
    private long idTo;

    private SenderDTO sender;

    private RecipientDTO recipient;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public SenderDTO getSender() {
        return sender;
    }

    public void setSender(SenderDTO sender) {
        this.sender = sender;
    }

    public RecipientDTO getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientDTO recipient) {
        this.recipient = recipient;
    }

    public ParcelDTO() {
    }

    public ParcelDTO(Long id, String name, int weight, long idFrom, long idTo, SenderDTO sender, RecipientDTO recipient) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.sender = sender;
        this.recipient = recipient;
    }
}
