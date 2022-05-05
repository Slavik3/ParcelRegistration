package com.post.parcel_registration.repository;

import com.post.parcel_registration.model.ParcelRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRegistrationRepository extends JpaRepository<ParcelRegistration, Long> {
}
