package com.api.api.repository;

import com.api.api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface UserRepo extends JpaRepository<UserModel, Long> {
        UserModel findByEmail(String email);

}
