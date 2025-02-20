package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> getAll() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product save(Product book) {
        return mongoTemplate.insert(book);
    }

    public List<Product> saveMultiple(List<Product> products) {
        return mongoTemplate.insertAll(products).stream().toList();
    }

    @Override
    public Product update(String id, Product book) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", book.getName());
        update.set("qty", book.getQty());
        update.set("vendor", book.getVendor());
        update.set("cost", book.getCost());

        mongoTemplate.updateFirst(query, update, Product.class);

        book.setId(id);
        return book;
    }

    public Product update2(String id, Product book) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", book.getName());
        update.set("qty", book.getQty());
        update.set("vendor", book.getVendor());
        update.set("cost", book.getCost());

        return mongoTemplate.findAndModify(query, update, Product.class);
    }

    public void discount10OnAllProductsAbove1000() {
        Query query = new Query();
        query.addCriteria(Criteria.where("cost").gt(1000));

        Update update = new Update();
        update.multiply("cost", 0.9);

        mongoTemplate.updateMulti(query, update, Product.class);
    }

    @Override
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Product.class);
    }

    public void deleteAllProductsCostingOver1000() {
        Query query = new Query();
        query.addCriteria(Criteria.where("cost").gt(1000));
        mongoTemplate.findAllAndRemove(query, Product.class);
    }

    @Override
    public Product getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Product product = mongoTemplate.findOne(query, Product.class);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in database");
        }
        return product;
    }

    public Product getById2(String id) {
        Product product = mongoTemplate.findById(id, Product.class);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in database");
        }
        return product;
    }
}
