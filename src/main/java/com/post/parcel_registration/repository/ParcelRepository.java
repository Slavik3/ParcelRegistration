package com.post.parcel_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.parcel_registration.dto.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
