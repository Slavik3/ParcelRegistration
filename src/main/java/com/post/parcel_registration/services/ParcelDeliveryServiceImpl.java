package com.post.parcel_registration.services;

import com.post.parcel_registration.model.Parcel;
import com.post.parcel_registration.model.ParcelRegistration;
import com.post.parcel_registration.repository.ParcelRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelDeliveryServiceImpl implements ParcelDeliveryService {

    @Autowired
    private PostOfficeManagementServiceClient postOfficeManagementServiceClient;

    @Autowired
    private ParcelRegistrationRepository parcelRegistrationRepository;


    public void registerParcel(ParcelRegistration parcelRegistration) {
        Parcel parcel = parcelRegistration.getParcel();
        boolean isPostOfficeAvailable = postOfficeManagementServiceClient.isPostOfficeAvailable(parcel.getIdTo());

        if(isPostOfficeAvailable) {
            parcelRegistrationRepository.save(parcelRegistration);
        }

    }
}
