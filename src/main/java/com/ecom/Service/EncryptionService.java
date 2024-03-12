package com.ecom.Service;

public interface EncryptionService {

    public String encryptPassword(String password);

    public Boolean verifyPassword(String password, String hash);
}
