package com.example.capstone1.Service;

import com.example.capstone1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

@RequiredArgsConstructor
public class UserService {
    private final ProductService productService;
    private final MerchantStockService merchantStockService;


    //10- Create endpoint for getting and adding and deleting updating a User

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }


    public void addUser(User user) {
        users.add(user);
    }


    public boolean updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equalsIgnoreCase(id)) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }


    public boolean deleteUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equalsIgnoreCase(id)) {
                users.remove(i);
                return true;
            }

        }
        return false;
    }


    //12- Create endpoint where user can buy a product directly
    //• this endpoint should accept user id, product id, merchant id.
    //• check if all the given ids are valid or not
    //• check if the merchant has the product in stock or return bad request.
    //• reduce the stock from the MerchantStock.
    //• deducted the price of the product from the user balance.
    //• if balance is less than the product price return bad request.

    public Boolean buyProduct(String userId, String productId, String merchantId) {
        double price = 0;
        for (User user : users) {
            if (user.getId().equals(userId)) {
                if (merchantStockService.searchIdMerchant(merchantId)) {
                    if (merchantStockService.searchIdProduct(productId)) {
                        if(merchantStockService.findLowStock(productId)>0)
                        if (merchantStockService.reducesStock(productId)) {
                            price = productService.getPriceOfProduct(productId);
                            if (price > 0) {
                                user.setBalance(user.getBalance() - price);
                                return true;
                            }
                        }
                    }

                }
            }
        }


        return false;
    }

}

//      public boolean buyProduct(String userId, String productId, String merchantId) {
//        double price = 0;
//          for (User user : users) {
//             if (user.getId().equals(userId)) {
//                 if (merchantStockService.searchIdMerchant(merchantId)) {
//                     if (merchantStockService.searchIdProduct(productId)) {
//                         if (merchantStockService.reducesStock(productId)) {
//                             price = productService.getPriceOfProduct(productId);
//                                if (price > 0) {
//                                 user.setBalance(user.getBalance() - price);
//                                 return true;
//                                         }
//                                       }
//                                     } else {
//                               return false;
//                                }
//                               }
//                              }
//                      return false;
//              }
//            }



//    public String buyProduct(int userID, int productId, int merchantId) {
//        int price = productService.getPriceOfProduct(productId);
//        if (price > 0) {
//            for (int i = 0; i < users.size(); i++) {
//                if (users.get(i).getId() == userID) {
//                    if (merchantStockService.searchIdMerchant(merchantId)) {
//                        if (merchantStockService.reduceStock(productId)) {
//                            users.get(i).setBalance(users.get(i).getBalance() - price);
//                            return null;
//                        }
//                    } else {
//                        return "Bad request";
//                    }
//                }
//            }
//        }
//        return "";
//    }


//    public String buyProduct(String userID,String productId,String merchantId){//ss
//        double Price=0;
//        for(int i=0;i<users.size();i++){
//            if(users.get(i).getId()==userID){
//                if(merchantStockService.searchIdMerchant(merchantId)){
//                    if(merchantStockService.reducesStock(productId)){
//if(merchantStockService.searchIdProduct(productId)){
//                        if(productService.getPriceOfProduct(productId)>0){
//                            Price=productService.getPriceOfProduct(productId);
//                            users.get(i).setBalance(users.get(i).getBalance()-Price);
//                            return null;
//                        }
//                    }
//                } else return "Bad request";
//            }
//        }
//        return "";
//    }









