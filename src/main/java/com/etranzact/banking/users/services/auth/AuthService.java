package com.etranzact.banking.users.services.auth;


import com.etranzact.banking.users.dto.SignupDTO;
import com.etranzact.banking.users.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
