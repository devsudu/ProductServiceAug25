package dev.sudu.productserviceaug25.service;

import dev.sudu.productserviceaug25.exceptions.ProductNotFoundException;
import dev.sudu.productserviceaug25.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    Product createProduct(Product product);

    Product replaceProduct(Long productId, Product product);

}
