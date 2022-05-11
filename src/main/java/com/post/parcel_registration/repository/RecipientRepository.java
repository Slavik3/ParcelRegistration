package com.post.parcel_registration.repository;

import com.post.parcel_registration.model.Person;
import com.post.parcel_registration.model.Recipient;
import com.post.parcel_registration.model.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
