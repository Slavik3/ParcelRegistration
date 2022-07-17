package com.post.parcel_registration.services;

//import com.post.parcel_registration.dto.Parcel;
import com.google.gson.Gson;
import com.post.parcel_registration.model.*;
import com.post.parcel_registration.repository.ParcelRepository;
import com.post.parcel_registration.repository.RecipientRepository;
import com.post.parcel_registration.repository.SenderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@RequiredArgsConstructor
@Component
public class ParcelDeliveryServiceImpl implements ParcelDeliveryService {

    private PostOfficeManagementServiceClient postOfficeManagementServiceClient;
    private ParcelRepository parcelRepository;
    private SenderRepository senderRepository;
    private RecipientRepository recipientRepository;

    /*@Autowired
    public ParcelDeliveryServiceImpl(PostOfficeManagementServiceClient postOfficeManagementServiceClient,
                                     ParcelRepository parcelRepository, SenderRepository senderRepository, RecipientRepository recipientRepository) {
        this.postOfficeManagementServiceClient = postOfficeManagementServiceClient;
        this.parcelRepository = parcelRepository;
        this.senderRepository = senderRepository;
        this.recipientRepository = recipientRepository;
    }*/
    Parcel pa=null;
    public ResponseEntity<?> registerParcel(Parcel parcel) {
        ParcelRegistrationProducer.send(parcel);
        pa=parcel;
        //produce(parcel);

        /*boolean isPostOfficeAvailable = postOfficeManagementServiceClient.isPostOfficeAvailable(parcel.getIdTo());
        if (isPostOfficeAvailable) {
            recipientRepository.save(parcel.getRecipient());
            senderRepository.save(parcel.getSender());
            parcelRepository.save(parcel);
            return new ResponseEntity<>("parcel registered", HttpStatus.OK);
        } else return new ResponseEntity<>("post office not available", HttpStatus.NOT_FOUND);*/
        return null;
    }


    private final KafkaTemplate<String, String> producer;

    /*public void produce(Parcel parcel) {
        System.out.println("ProducerExample");
        final String key = "postOfficeKey";
        log.info("Producing record: {}\t{}", key, parcel);
        producer.send("bbb", key, parcel.toString()).addCallback(
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
        log.info("parcel produced");
    }*/

    @Transactional
    @KafkaListener(topics = "postOffice")
    public void consume(final ConsumerRecord<String, PostOffice> postOffice) {
        Gson gson = new Gson();
        PostOffice po = gson.fromJson(String.valueOf(postOffice.value()), PostOffice.class);

        log.info(".key()==> " + postOffice.key());
        log.info(".value()==> " + postOffice.value());
        Long id = po.getId();
        Boolean isPostOfficeAvailable = po.getIsWorking();
        log.info("id==> " + id);
        log.info("isWorking==> " + isPostOfficeAvailable);


        if (isPostOfficeAvailable) {
            recipientRepository.save(pa.getRecipient());
            senderRepository.save(pa.getSender());
            parcelRepository.save(pa);
            //return new ResponseEntity<>("parcel registered", HttpStatus.OK);
        } //else return new ResponseEntity<>("post office not available", HttpStatus.NOT_FOUND);
    }

}
