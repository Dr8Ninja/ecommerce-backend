package com.ecom.Service;

import com.ecom.Model.User;

public interface JWTService {
    public String generateJWT(User user);
}
