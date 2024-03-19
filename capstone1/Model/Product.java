package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
//1- Create Product Class:
//            • id (must not be empty).
//            • name (must not be empty, have to be more than 3 length long).
//            • price (must not be empty, must be positive number).
//            • categoryID (must not be empty).


//    @NotNull(message = "id must not be empty ")
//    private Integer id;

    @NotEmpty(message ="Id must not be empty")
    private String id;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 4,message = " Name have to be more than 3 length long")
    private String name;


    @NotNull(message = "must not be empty")
    @Positive(message = "must be positive number")
    private Double  price ;

    //@NotNull(message = "must not be empty")
    @NotEmpty(message ="categoryID must not be empty")
    private String categoryID;


















}
