package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("Product1.png");

        // save product
        Product savedObject =  productRepository.save(product);


        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {

        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("Product1.png");

        // create product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("Product2.png");

        productRepository.saveAll(List.of(product, product2));

    }

    @Test
    void findAllMethod() {

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> System.out.println(p.getName()));

    }

    @Test
    void deleteByMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        //delete entity
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod() {

//        productRepository.deleteAll();
        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product, product1));

    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 8L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }



}
