package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {

//    private final ProductService productService;
//    private final MerchantService merchantService;
//    private final MerchantStockService merchantStockService;
    private  final  CategoryService categoryService;

    //8- Create endpoint for getting and adding and deleting updating a
    //Merchant
    ArrayList<Merchant> merchants=new ArrayList<>();



    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }


    public void addMerchant(Merchant merchant){

        merchants.add(merchant);
    }

    public boolean updateMerchant(String id,Merchant merchant){
        for(int i=0; i<merchants.size();i++){
            if(merchants.get(i).getId().equalsIgnoreCase(id)){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchant(String id){
        for (int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId().equalsIgnoreCase(id)){
                merchants.remove(i);
                return true;
            }

        }
        return  false;
    }


    public Merchant getMerchantById(String id) {
        for (Merchant merchant : merchants) {
            if (merchant.getId().equalsIgnoreCase(id)){
                return merchant;
            }
        }
        return null;
    }


}







