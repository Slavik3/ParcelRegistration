package com.post.parcel_registration.controller;


import com.post.parcel_registration.dto.ParcelDTO;
import com.post.parcel_registration.model.Parcel;
import com.post.parcel_registration.services.ParcelDeliveryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParcelDeliveryController {

    private ParcelDeliveryService parcelDeliveryService;
    private ModelMapper modelMapper;

    @Autowired
    public ParcelDeliveryController(ParcelDeliveryService parcelDeliveryService, ModelMapper modelMapper) {
        this.parcelDeliveryService = parcelDeliveryService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/parcel/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerParcel(@RequestBody ParcelDTO parcelDTO) {
        //Parcel parcel= modelMapper.map(parcelDTO, Parcel.class);
        return parcelDeliveryService.registerParcel(parcelDTO);
    }


}
