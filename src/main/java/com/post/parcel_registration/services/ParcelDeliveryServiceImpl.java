package com.post.parcel_registration.services;

import com.google.gson.Gson;
import com.post.parcel_registration.dto.ParcelDTO;
import com.post.parcel_registration.dto.ParcelRegistrationCompleted;
import com.post.parcel_registration.model.*;
import com.post.parcel_registration.repository.ParcelRepository;
import com.post.parcel_registration.repository.RecipientRepository;
import com.post.parcel_registration.repository.SenderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class ParcelDeliveryServiceImpl implements ParcelDeliveryService {

    private ParcelRepository parcelRepository;
    private SenderRepository senderRepository;
    private RecipientRepository recipientRepository;
    private ModelMapper modelMapper;
    private KafkaTemplate<String, ParcelDTO> producer;
    @Autowired
    public ParcelDeliveryServiceImpl(ModelMapper modelMapper, RecipientRepository recipientRepository, SenderRepository senderRepository, ParcelRepository parcelRepository, KafkaTemplate<String, ParcelDTO> producer) {
        this.modelMapper = modelMapper;
        this.recipientRepository = recipientRepository;
        this.senderRepository = senderRepository;
        this.parcelRepository = parcelRepository;
        this.producer = producer;
    }

    public void registerParcel(ParcelDTO parcel) {
        produce(parcel);
    }

    public void produce(ParcelDTO parcel) {
        System.out.println("produce parcelRegistrationInitiate");
        final String key = "parcelRegistrationInitiate";
        log.info("Producing record: {}\t{}", key, parcel);
        producer.send("parcelRegistrationInit", key, parcel).addCallback(
                result -> {
                    final RecordMetadata m;
                    if (result != null) {
                        m = result.getRecordMetadata();
                        log.info("Produced record to topic {} partition {} @ offset {}",
                                m.topic(),
                                m.partition(),
                                m.offset());
                    }
                },
                exception -> log.error("Failed to produce to kafka", exception));
        producer.flush();
    }

    @KafkaListener(topics = "parcelRegistration")
    public void consume(final ConsumerRecord<String, ParcelRegistrationCompleted> readParcelRegistrationCompletedObj) {
        if (readParcelRegistrationCompletedObj.key().equals("parcelRegistrationCompleted")) {
            Gson gson = new Gson();
            ParcelRegistrationCompleted parcelRegistrationCompleted = gson.fromJson(String.valueOf(readParcelRegistrationCompletedObj.value()), ParcelRegistrationCompleted.class);
            Boolean isPostOfficeAvailable = parcelRegistrationCompleted.getIsPostOfficeAvailable();
            if (isPostOfficeAvailable) {
                ParcelDTO parcelDTO = parcelRegistrationCompleted.getParcel();
                Parcel parcel = modelMapper.map(parcelDTO, Parcel.class);
                recipientRepository.save(parcel.getRecipient());
                senderRepository.save(parcel.getSender());
                parcelRepository.save(parcel);
                //return new ResponseEntity<>("parcel registered", HttpStatus.OK);
            } //else return new ResponseEntity<>("post office not available", HttpStatus.NOT_FOUND);
        }
    }
}
