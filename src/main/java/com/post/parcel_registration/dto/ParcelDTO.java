package com.post.parcel_registration.dto;

import com.post.parcel_registration.model.Parcel;
import com.post.parcel_registration.model.Recipient;
import com.post.parcel_registration.model.Sender;

import java.util.Objects;

public class ParcelDTO {
    private String name;
    private int weight;
    private long idFrom;
    private long idTo;

    private SenderDTO sender;

    private RecipientDTO recipient;

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

    public ParcelDTO(String name, int weight, long idFrom, long idTo, SenderDTO sender, RecipientDTO recipient) {
        this.name = name;
        this.weight = weight;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcelDTO parcelDTO = (ParcelDTO) o;
        return weight == parcelDTO.weight && idFrom == parcelDTO.idFrom && idTo == parcelDTO.idTo && Objects.equals(name, parcelDTO.name) && Objects.equals(sender, parcelDTO.sender) && Objects.equals(recipient, parcelDTO.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, idFrom, idTo, sender, recipient);
    }

    @Override
    public String toString() {
        return "ParcelDTO{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", idFrom=" + idFrom +
                ", idTo=" + idTo +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }

    public Parcel convertToParcelEntity(){
        Parcel parcel = new Parcel();

        parcel.setWeight(this.getWeight());
        parcel.setName(this.getName());
        parcel.setIdFrom(this.getIdFrom());
        parcel.setIdTo(this.getIdTo());

        long senderDtoId = this.getSender().getId();
        String senderDtoName = this.getSender().getName();
        String senderDtoEmail = this.getSender().getEmail();
        String senderDtoPassportNumber = this.getSender().getPassportNumber();
        String senderDtoSurname = this.getSender().getSurname();
        int senderDtoPhoneNumber = this.getSender().getPhoneNumber();
        int senderDtoTaxNumber = this.getSender().getTaxNumber();
        Sender sender = new Sender();
        sender.setId(senderDtoId);
        sender.setName(senderDtoName);
        sender.setSurname(senderDtoSurname);
        sender.setEmail(senderDtoEmail);
        sender.setPassportNumber(senderDtoPassportNumber);
        sender.setPhoneNumber(senderDtoPhoneNumber);
        sender.setTaxNumber(senderDtoTaxNumber);
        parcel.setSender(sender);

        long recipientDtoId = this.getRecipient().getId();
        String recipientDtoName = this.getRecipient().getName();
        String recipientDtoEmail = this.getRecipient().getEmail();
        String recipientDtoPassportNumber = this.getRecipient().getPassportNumber();
        String recipientDtoSurname = this.getRecipient().getSurname();
        int recipientDtoPhoneNumber = this.getRecipient().getPhoneNumber();
        int recipientDtoTaxNumber = this.getRecipient().getTaxNumber();
        Recipient recipient = new Recipient();
        recipient.setId(recipientDtoId);
        recipient.setName(recipientDtoName);
        recipient.setSurname(recipientDtoSurname);
        recipient.setEmail(recipientDtoEmail);
        recipient.setPassportNumber(recipientDtoPassportNumber);
        recipient.setPhoneNumber(recipientDtoPhoneNumber);
        recipient.setTaxNumber(recipientDtoTaxNumber);
        parcel.setRecipient(recipient);

        return parcel ;
    }
}
