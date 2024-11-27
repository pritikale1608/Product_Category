package com.assignment.product_category.serviceimple;

import com.assignment.product_category.model.Product;
import com.assignment.product_category.repository.ProductRepository;
import com.assignment.product_category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product SaveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> getAllProduct(Integer no, Integer size) {
        Pageable pageable = PageRequest.of(no, size);
        Page<Product> productList = productRepository.findAll(pageable);
        return productList;
    }
//
//
    @Override
    public Optional<Product> UpdateProduct(Integer id, Product updatedProduct) {
            return productRepository.findById(id)
                    .map(existing -> {
                        existing.setPname(updatedProduct.getPname());
                        existing.setPid(updatedProduct.getPid());
                        return productRepository.save(existing);
                    });
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
