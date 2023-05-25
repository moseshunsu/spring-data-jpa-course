package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    Product findDistinctByName(String name);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameLike(String name);
//    @Query("select p from Product p where p.price between ?1 and ?2")
    List<Product> findByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
//    @Query("select p from Product p where p.name in ?1")
    List<Product> findByNameIn(Collection<String> names);
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop2ByOrderByPriceDesc();


}
