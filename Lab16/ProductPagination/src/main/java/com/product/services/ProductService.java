package com.product.services;

import com.product.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductSorted(String field);
    Page<Product> getAllProductPage(int offset, int pageSize);
    Page<Product> getAllProductPageSorted(String field, int offset, int pageSize);
}
