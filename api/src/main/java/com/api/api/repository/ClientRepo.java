package com.api.api.repository;

import com.api.api.model.ClientModel;
import com.api.api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<ClientModel, Long> {


    Optional<ClientModel> findByBookingID(String bookingID);
}
