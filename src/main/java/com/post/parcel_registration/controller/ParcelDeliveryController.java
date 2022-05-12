package com.post.parcel_registration.controller;


import com.post.parcel_registration.dto.Parcel;
import com.post.parcel_registration.services.ParcelDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParcelDeliveryController {

    private ParcelDeliveryService parcelDeliveryService;

    @Autowired
    public ParcelDeliveryController(ParcelDeliveryService parcelDeliveryService) {
        this.parcelDeliveryService = parcelDeliveryService;
    }

    @RequestMapping(value = "/registerParcel", method = RequestMethod.POST)
    public ResponseEntity<?> registerParcel(@RequestBody Parcel parcel) {
        return parcelDeliveryService.registerParcel(parcel);
    }


}
