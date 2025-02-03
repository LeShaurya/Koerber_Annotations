package com.product.services;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService{
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProductSorted(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, 			pageSize).withSort(Sort.by(field)));
    }
}
