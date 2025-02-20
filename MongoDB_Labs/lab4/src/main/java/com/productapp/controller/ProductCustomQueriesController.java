package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductCustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCustomQueriesController {
    private ProductCustomQueries productCustomQueries;

    @Autowired
    public ProductCustomQueriesController(ProductCustomQueries productCustomQueries) {
        this.productCustomQueries = productCustomQueries;
    }

    @GetMapping("products/vendor/{vendor}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByVendorOrName(@PathVariable String vendor, @PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productCustomQueries.getProductsByVendorOrName(vendor, name));
    }

    @GetMapping("products/vendor/{vendor}/count")
    public ResponseEntity<Integer> getProductsCountByVendor(@PathVariable String vendor) {
        return ResponseEntity.status(HttpStatus.OK).body(productCustomQueries.getProductsCountByVendor(vendor));
    }

    @GetMapping("products/vendor/{vendor}/sort")
    public ResponseEntity<List<Product>> getProductsByVendorSortByName(@PathVariable String vendor) {
        return ResponseEntity.status(HttpStatus.OK).body(productCustomQueries.getProductsByVendorSortByName(vendor));
    }

}
