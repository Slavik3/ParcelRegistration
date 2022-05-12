package com.post.parcel_registration.repository;

import com.post.parcel_registration.dto.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
}
