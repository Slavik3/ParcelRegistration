package com.post.parcel_registration.controller;

import com.post.parcel_registration.model.Parcel;
import com.post.parcel_registration.model.Recipient;
import com.post.parcel_registration.model.Sender;
import com.post.parcel_registration.services.ParcelDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParcelDeliveryController {

    private ParcelDeliveryService parcelDeliveryService;

    @Autowired
    public ParcelDeliveryController(ParcelDeliveryService parcelDeliveryService) {
        this.parcelDeliveryService = parcelDeliveryService;
    }

    @RequestMapping(value = "/registerParcel", method = RequestMethod.POST)
    public HttpStatus registerParcel(@RequestBody Parcel parcel) {
        parcelDeliveryService.registerParcel(parcel);
        return HttpStatus.OK;
    }


}
