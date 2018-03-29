/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecm.models;

import com.ecm.entities.Product;
import com.ecm.da.ProductDataAccess;
import java.util.List;

/**
 *
 * @author PHUONGTHUAN
 */
public class ProductFinderBean {
    
    private String keyword;
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public List<Product> getProducts() {
        return new ProductDataAccess().getProductsByName(keyword);
    }
    
    public List<Product> getAllProducts() {
        return new ProductDataAccess().getAllProducts();
    }
}
