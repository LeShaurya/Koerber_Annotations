package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCustomQueries {
    private ProductRepo productRepo;

    @Autowired
    public ProductCustomQueries(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProductsByVendorOrName(String vendor, String name) {
        return productRepo.getProductsByVendorOrName(vendor, name);
    }

    public int getProductsCountByVendor(String vendor) {
        return productRepo.getProductsCountByVendor(vendor);
    }

    public List<Product> getProductsByVendorSortByName(String vendor) {
        return productRepo.getProductsByVendorSortByName(vendor);
    }
}
