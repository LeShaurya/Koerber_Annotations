package com.product.controller;

import com.product.entities.Product;
import com.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping(path = "productsorted")
    public List<Product> getAllProductSorted(@RequestParam(name="field")  String field) {
        return productService.getAllProductSorted(field);
    }

    //productpage?offset=4&pageSize=20
    @GetMapping(path = "productpage")
    public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset,@RequestParam(name="pageSize") int pageSize) {
        return productService.getAllProductPage(offset, pageSize);
    }

    //productpagesorted?offset=4&pageSize=20&field=id
    @GetMapping(path = "productpagesorted")
    public Page<Product> getAllProductPageSorted(int offset, int pageSize, String field) {
        return productService.getAllProductPageSorted(field, offset, pageSize);
    }
}
