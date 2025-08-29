package dev.sudu.productserviceaug25.repositories;

import dev.sudu.productserviceaug25.models.Product;
import dev.sudu.productserviceaug25.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Declared Queries
    @Override
    Optional<Product> findById(Long id);

    // select * from products
    @Override
    List<Product> findAll();

    // select * from products where title = ?
    List<Product> findByTitle(String title);

    // select * from products where title LIKE '%str%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    // select * from products where price >= start and price <= end
    List<Product> findByPriceBetween(Double start, Double end);

    // select * from products where title LIKE '%str%' and price >= start and price <= end
    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(String title, Double start, Double end);

    List<Product> findByCreatedAtBetween(Date start, Date end);

    void deleteById(Long id);

    Product save(Product product);

    // Query: Find the title and price of the product with id = 10
    // select title, price from products where id = 10;
    @Query(value = "select p.title, p.price from products p where p.id = 1", nativeQuery = true)
    List<ProductWithTitleAndPrice> findTitleAndPriceById();

//    Optional<Product> findBYCategory(String category);

    Optional<Product> findByCategory_Title(String title);
}
