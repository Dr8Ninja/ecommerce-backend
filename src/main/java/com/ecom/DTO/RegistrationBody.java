package com.ecom.DTO;

import jakarta.validation.constraints.*;

public class RegistrationBody {

    @NotNull
    @NotBlank
    @Size.List({
            @Size(min = 3, message = "{validation.name.size.too_short}"),
            @Size(max = 255, message = "{validation.name.size.too_long}")
    })
    private String username;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Size.List({
            @Size(min = 6, message = "{validation.name.size.too_short}"),
            @Size(max = 32, message = "{validation.name.size.too_long}")
    })
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$") // Minimum 6 characters with at least 1 number and 1 letter
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
