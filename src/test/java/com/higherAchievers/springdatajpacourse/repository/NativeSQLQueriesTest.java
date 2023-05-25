package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){

        Product product = productRepository.findByNameOrDescriptionSQLIndexParam(
                "product 1", "product 1 description");
        System.out.println("product = " + product);

    }

    @Test
    void findByNameOrDescriptionSQLIndexNamedMethod(){

        Product product = productRepository.findByNameOrDescriptionSQLNamedParam(
                "product 1", "product 1 description");
        System.out.println("product = " + product);

    }

}
