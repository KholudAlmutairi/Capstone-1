package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
//    4- Create MerchantStock Class:
//            • id (must not be empty).
//            • productid (must not be empty).
//            • merchantid (must not be empty).
//            • stock (must not be empty, have to be more than 10 at start)


//    @NotNull(message = "id must not be empty ")
//    private Integer id;

    @NotEmpty(message ="Id must not be empty")
    private String id;

    @NotEmpty(message = "id productid must not be empty ")
    private String productid;

    @NotEmpty(message = "merchant id must not be empty ")
    private String merchantid ;

      //@NotNull(message = "name must not be empty")
      //@Pattern(regexp = "")//Stock have to be more than 10 length long
      @NotNull(message = "Stock must not be empty")
      @Min(value = 11, message = "Stock must be more than 10")
      private Integer stock=10;


      //@Size(min = 10,message = " Stock have to be more than 10 length long")
      //@Min(10)
      //private int stock=10;











}
