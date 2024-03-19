package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


//    5- Create User Class:
//            • id (must not be empty).
//            • username (must not be empty, have to be more than 5 length long).
//            • password (must not be empty, have to be more than 6 length long, must have
//characters and digits).
//            • email (must not be empty, must be valid email).
//            • role (must not be empty, have to be in ( “Admin”,”Customer”)).
//            • balance (must not be empty, have to be positive).



//    @NotNull(message = "Id must not be empty ")
//    private Integer id;

    @NotEmpty(message ="Id must not be empty")
    private String id;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 6,message = " Username have to be more than 5 length long")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 7,message = " Password have to be more than 6 length long And must have characters and digits")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$")
    private String password;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid email")
    private String email;

    @NotEmpty(message = " Role must not be empty")
    @Pattern(regexp = "^(Admin|Customer)$")
    private String role;

    @NotNull(message = "Balance must not be empty")
    @Positive(message = " Balance have to be positive")
    private Double balance;




}
