package dev.sudu.productserviceaug25.service;

import dev.sudu.productserviceaug25.exceptions.ProductNotFoundException;
import dev.sudu.productserviceaug25.models.Category;
import dev.sudu.productserviceaug25.models.Product;
import dev.sudu.productserviceaug25.repositories.CategoryRepository;
import dev.sudu.productserviceaug25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId);
        }

        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        // Validations
//        if(product.getId() == null){
//            Optional<Product> optionalProduct = productRepository.findById(product.getId());
//
//            if(optionalProduct.isEmpty()){
//                throw new RuntimeException("Invalid Product");
//            }
//        }

        Category category = product.getCategory();

        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if(optionalCategory.isEmpty()){
            // Create a category
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
