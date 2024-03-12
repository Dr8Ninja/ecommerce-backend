package com.ecom.Service;

import com.ecom.Controller.Model.LoginBody;
import com.ecom.Controller.Model.RegistrationBody;
import com.ecom.Exception.UserAlreadyExistsException;
import com.ecom.Model.User;
import com.ecom.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    JWTService jwtService;


    public void registerUser(RegistrationBody user) throws UserAlreadyExistsException{
        User newuser = new User();
        if(userRepository.findByEmail(user.getEmail()).isPresent() || userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        newuser.setUsername(user.getUsername());
        newuser.setFirstName(user.getFirstName());
        newuser.setLastName(user.getLastName());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));

        userRepository.save(newuser);
    }

    public String loginUser(LoginBody loginBody){
        Optional<User> optionalUser = userRepository.findByUsername(loginBody.getUsername());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
            else{
                return "Wrong Password";
            }
        }
        return null;
    }
}
