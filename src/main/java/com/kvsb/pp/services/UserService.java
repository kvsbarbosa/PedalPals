package com.kvsb.pp.services;

import com.kvsb.pp.dto.RegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(RegistrationDTO registrationDTO);


}
