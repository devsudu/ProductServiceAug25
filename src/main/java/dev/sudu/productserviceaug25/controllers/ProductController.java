package dev.sudu.productserviceaug25.controllers;

import dev.sudu.productserviceaug25.models.Product;
import dev.sudu.productserviceaug25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId){
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long productId, @RequestBody Product product) {
        return null;
    }

    @PatchMapping("/")
    public Product updateProduct(@RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

    }
}
