package com.post.parcel_registration.services;

import com.post.parcel_registration.model.Parcel;
import org.springframework.http.ResponseEntity;

public interface ParcelDeliveryService {
    public ResponseEntity<?> registerParcel(Parcel parcel);
}
