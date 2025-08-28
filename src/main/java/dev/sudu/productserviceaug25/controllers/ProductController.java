package dev.sudu.productserviceaug25.controllers;

import com.sun.jdi.VoidValue;
import dev.sudu.productserviceaug25.exceptions.ProductNotFoundException;
import dev.sudu.productserviceaug25.models.Product;
import dev.sudu.productserviceaug25.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/{productId}")
//    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
//        try{
//            Product product = productService.getSingleProduct(productId);
//            return new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        }catch (RuntimeException e) {
//            return new ResponseEntity<>(
//                    null,
//                    HttpStatus.INTERNAL_SERVER_ERROR
//            );
//        }
//    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
       return productService.getSingleProduct(productId);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        try{
//            List<Product> products = productService.getAllProducts();
//            return new ResponseEntity<>(
//                    products,
//                    HttpStatus.OK
//            );
//        }catch (RuntimeException e) {
//            return new ResponseEntity<>(
//                    null,
//                    HttpStatus.INTERNAL_SERVER_ERROR
//            );
//        }
//    }

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


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(
                "Product not found, Please try again",
                HttpStatus.NOT_FOUND
        );
    }
}
