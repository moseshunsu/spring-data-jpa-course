package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    Product findDistinctByName(String name);
    List<Product> findByPriceGreaterThan(BigDecimal price);

}
