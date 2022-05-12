package com.post.parcel_registration.services;

import org.springframework.http.ResponseEntity;

import com.post.parcel_registration.dto.Parcel;

public interface ParcelDeliveryService {
    public ResponseEntity<?> registerParcel(Parcel parcel);
}
