package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    
    @Autowired
    private 
    ProductRepository productRepository;
    
    @Test
    void namedJPQLQuery(){

        Product product = productRepository.findByPrice(new BigDecimal(100));

        System.out.println("product = " + product);
        
    }

    @Test
    void namedJPQLQueries(){

        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach(p -> {
            System.out.println(p.getName());
        });

        Product product = productRepository.findByPrice(new BigDecimal(200));
        System.out.println("product = " + product);

    }

    @Test
    void namedSQLQuery(){

        Product product = productRepository.findByDescription("product 1 description");

        System.out.println(product);

    }

    @Test
    void namedNativeSQLQueries(){
        Product product = productRepository.findByDescription("product 3 description");
        System.out.println(product);

        List<Product> products = productRepository.findAllOrderByNameAsc();
        products.forEach(System.out::println);
    }



}










