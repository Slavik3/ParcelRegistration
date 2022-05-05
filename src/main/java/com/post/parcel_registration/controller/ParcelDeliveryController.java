package com.post.parcel_registration.controller;

import com.post.parcel_registration.model.ParcelRegistration;
import com.post.parcel_registration.services.ParcelDeliveryService;
import com.post.parcel_registration.services.PostOfficeManagementServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParcelDeliveryController {

    @Autowired
    private PostOfficeManagementServiceClient postOfficeManagementServiceClient;

    @Autowired
    private ParcelDeliveryService parcelDeliveryService;

    @RequestMapping(value = "/registerParcel", method = RequestMethod.POST)
    public HttpStatus registerParcel(@RequestBody ParcelRegistration parcelRegistration) {
        parcelDeliveryService.registerParcel(parcelRegistration);
        return HttpStatus.OK;
    }


}
