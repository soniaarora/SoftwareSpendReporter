package com.servicenow.assignment.model;

import java.util.Map;
import java.util.TreeMap;

/*
 * Vendor class
 */
public class Vendor {
    private String vendorName;
    private Map<String, Product> productMap = new TreeMap();;

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public Product addProduct(String productName) {
        if(!productMap.containsKey(productName.toLowerCase())) {
            Product product = new Product(productName);
            productMap.put(productName.toLowerCase(), product);
            return product;
        }
        return productMap.get(productName.toLowerCase());
    }

    public Product getProduct(String productName) {
        if(productMap.containsKey(productName.toLowerCase())) {
            return productMap.get(productName.toLowerCase());
    }
        return null;
    }

}
