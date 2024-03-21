package com.example.capstone1.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

//    3- Create Merchant Class:
//            • id (must not be empty).
//            • name (must not be empty, have to be more than 3 length long).


//    @NotNull(message = "Id must not be empty")
//    private Integer id;

    @NotEmpty(message ="Id must not be empty")
    private String id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 4,message = " Name have to be more than 3 length long")
    private String name;







}
