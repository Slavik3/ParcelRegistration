package com.post.parcel_registration.dto;

public class ParcelRegistrationCompleted {
    private ParcelDTO parcel;
    private Boolean isPostOfficeAvailable;

    public ParcelDTO getParcel() {
        return parcel;
    }

    public Boolean getIsPostOfficeAvailable() {
        return isPostOfficeAvailable;
    }

    public void setParcel(ParcelDTO parcel) {
        this.parcel = parcel;
    }

    public void setIsPostOfficeAvailable(Boolean isPostOfficeAvailable) {
        isPostOfficeAvailable = isPostOfficeAvailable;
    }

    public ParcelRegistrationCompleted(ParcelDTO parcel, Boolean isAvailable) {
        this.parcel = parcel;
        this.isPostOfficeAvailable = isPostOfficeAvailable;
    }

    @Override
    public String toString() {
        return "SendParcelRegistrationCompleted{" +
                "parcel=" + parcel +
                ", isPostOfficeAvailable=" + isPostOfficeAvailable +
                '}';
    }
}
