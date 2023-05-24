package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {

        Product product = productRepository.findByName("product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = productRepository.findByNameOrDescription("product 1",
                "product 2 description");

        products.forEach( p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

    }

    @Test
    void findByNameAndDescriptionMethod() {

        List<Product> products = productRepository.findByNameAndDescription("product 2",
                "product 2 description");

        products.forEach( p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

    }

    @Test
    void findDistinctByName() {
        Product product = productRepository.findDistinctByName("product 3");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(150));
        products.forEach( product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

}










