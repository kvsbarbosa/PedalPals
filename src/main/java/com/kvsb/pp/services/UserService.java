package com.kvsb.pp.services;

import com.kvsb.pp.dto.RegistrationDTO;
import com.kvsb.pp.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(RegistrationDTO registrationDTO);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);

}
