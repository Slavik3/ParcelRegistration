package com.post.parcel_registration.services;

//import com.post.parcel_registration.dto.Parcel;
import com.post.parcel_registration.dto.*;
import com.post.parcel_registration.repository.ParcelRepository;
import com.post.parcel_registration.repository.RecipientRepository;
import com.post.parcel_registration.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParcelDeliveryServiceImpl implements ParcelDeliveryService {

    private PostOfficeManagementServiceClient postOfficeManagementServiceClient;
    private ParcelRepository parcelRepository;
    private SenderRepository senderRepository;
    private RecipientRepository recipientRepository;

    @Autowired
    public ParcelDeliveryServiceImpl(PostOfficeManagementServiceClient postOfficeManagementServiceClient,
                                     ParcelRepository parcelRepository, SenderRepository senderRepository, RecipientRepository recipientRepository) {
        this.postOfficeManagementServiceClient = postOfficeManagementServiceClient;
        this.parcelRepository = parcelRepository;
        this.senderRepository = senderRepository;
        this.recipientRepository = recipientRepository;
    }

    public ResponseEntity<?> registerParcel(Parcel parcel) {
        boolean isPostOfficeAvailable = postOfficeManagementServiceClient.isPostOfficeAvailable(parcel.getIdTo());
        if (isPostOfficeAvailable) {
            recipientRepository.save(parcel.getRecipient());
            senderRepository.save(parcel.getSender());
            parcelRepository.save(parcel);
            return new ResponseEntity<>("parcel registered", HttpStatus.OK);
        } else return new ResponseEntity<>("post office not available", HttpStatus.NOT_FOUND);

    }
}
