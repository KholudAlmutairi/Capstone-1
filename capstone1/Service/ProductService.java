package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    //6- Create endpoint for getting and adding and deleting updating a Product.


    ArrayList<Product> products=new ArrayList<>();



    public ArrayList<Product> getProducts(){

        return products;
    }

//    private boolean isValidCategoryId(String categoryId) {
//
//        return categoryId != null && !categoryId.isEmpty();
//    }
//
//    public void addProduct(Product product,String categoryID){
//        if(isValidCategoryId(categoryID)){
//        products.add(product);
//    }else {
//            System.out.println("Cannot add the product, the category ID is invalid.");
//        }
//    }



    public Boolean isCategoryIdExists(String categoryID) {
        for (Product product : products) {
            if (product.getCategoryID().equalsIgnoreCase(categoryID)) {
                return true;
            }
        }
        return false;
    }


    public void addProduct(Product product, String categoryID) {
        if (isCategoryIdExists(categoryID)) {
            products.add(product);
        } else {
            throw new IllegalArgumentException("Cannot add the product, the category ID is invalid.");
        }
    }


    public boolean updateProduct(String id,Product product){
        for(int i=0; i<products.size();i++){
            if(products.get(i).getId().equalsIgnoreCase(id)){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }


    public boolean deleteProduct(String id){
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId().equalsIgnoreCase(id)){
                products.remove(i);
                return true;
            }

        }
        return  false;
    }

    //////////////////////////////////////////////
    public Boolean prodectId(String id){
        for(int i=0; i<products.size();i++){
            if(products.get(i).getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    //Endpoint 2
    public void applyDiscount(String categoryId, double discountPercentage) {
        for (Product product : getProductsByCategory(categoryId)) {
            double discountedPrice = product.getPrice() * (1 - (discountPercentage / 100));
            product.setPrice(discountedPrice);
        }
    }



    //Endpoint 1
    public ArrayList<Product> getProductsByCategory(String categoryId) {
        ArrayList<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategoryID().equalsIgnoreCase(categoryId)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }





    //public Shopping(){}


//    public boolean getProductById(String id){
//        for (Product product : products) {
//            if (product.getId().equalsIgnoreCase(id)) {
//                return true;
//            }
//        }
//        return false;
//    }



    public double getPriceOfProduct(String productId){
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(productId)) {
                return product.getPrice();}

        }
        return -1;
    }



















}
