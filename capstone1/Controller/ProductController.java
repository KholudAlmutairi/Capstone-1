package com.example.capstone1.Controller;

import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Service.CategoryService;
import com.example.capstone1.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    //6- Create endpoint for getting and adding and deleting updating a Product.


    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getProducts(){
        ArrayList<Product> products=productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("Product added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid Product product , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(message);
        }
        boolean idupdate =productService.updateProduct(id,product);
        if(idupdate){
            return ResponseEntity.status(200).body(new ApiResponse("Product updated"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Product not found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        boolean isDeleted= productService.deleteProduct(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Product Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Product not found!"));
    }


    @PostMapping("/applyDiscount/{categoryId}/{discountPercentage}")
    public ResponseEntity applyDiscount(@PathVariable String categoryId, @PathVariable double discountPercentage) {
        productService.applyDiscount(categoryId,discountPercentage);
        return ResponseEntity.status(200).body(new ApiResponse("Discount applied successfully"));
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity  getProductsByCategory(@PathVariable String categoryId) {
        ArrayList<Product> productsByCategory = productService.getProductsByCategory(categoryId);
        if (productsByCategory.isEmpty()) {
            return ResponseEntity.status(400).body("No products found in this category");
        }
        return ResponseEntity.ok(productsByCategory);
    }








//    @GetMapping("/get/{id}")
//    public ResponseEntity getProductById(@PathVariable String id) {
//       Product product =productService.getProductById(id);
//        if (product== null) {
//            return ResponseEntity.status(400).body(new ApiResponse("Product id not found"));
//        }
//        return ResponseEntity.status(200).body(product);
//    }



//    @GetMapping("/products/category/{categoryId}")
//    public ResponseEntity<ArrayList<Product>> getProductsByCategory(@PathVariable String categoryId)
//        if (!isValidCategoryId(categoryId)) {
//            return ResponseEntity.status(400).body(new ArrayList<>());
//        }
//
//        ArrayList<Product> productsByCategory = productService.getProductsByCategory(categoryId);
//        if (productsByCategory.isEmpty()) {
//            return ResponseEntity.status(400).body(new ArrayList<>());
//        }
//
//        return ResponseEntity.ok(productsByCategory);
//    }







}
