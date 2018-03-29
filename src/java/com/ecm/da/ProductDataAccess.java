/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecm.da;

import com.ecm.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PHUONGTHUAN
 */
public class ProductDataAccess {
    
    private PreparedStatement stm;
    
    private PreparedStatement getSearchStatement() throws ClassNotFoundException, SQLException {
        if (stm == null) {
            Connection conn = new DBConnection().getConnection();
            stm = conn.prepareStatement("SELECT id, name, description FROM products WHERE name like ?");
        }
        return stm;
    }
    
    private PreparedStatement getAllProductStatement() throws SQLException, ClassNotFoundException {
        if (stm == null) {
            Connection conn = new DBConnection().getConnection();
            stm = conn.prepareStatement("SELECT id, name, description FROM products");
        }
        return stm;
    }
    
    public List<Product> getProductsByName(String name) {
        try {

            PreparedStatement pstm = getSearchStatement();
            pstm.setString(1, "%"+name+"%");
            ResultSet rs = pstm.executeQuery();
            List<Product> products = new LinkedList<Product>();

            while(rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }

            return products;
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Product> getAllProducts() {
        List products = new ArrayList();

        try {
            PreparedStatement pstm = getAllProductStatement();
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setDescription(rs.getString(3));
                
                products.add(item);
            }
            
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return products;
    }
}
