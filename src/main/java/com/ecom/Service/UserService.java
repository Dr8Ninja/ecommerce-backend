package com.ecom.Service;

import com.ecom.DTO.LoginBody;
import com.ecom.DTO.RegistrationBody;
import com.ecom.Exception.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    public void registerUser(@RequestBody RegistrationBody registrationBody) throws UserAlreadyExistsException;

    public String loginUser(LoginBody loginBody);
}
