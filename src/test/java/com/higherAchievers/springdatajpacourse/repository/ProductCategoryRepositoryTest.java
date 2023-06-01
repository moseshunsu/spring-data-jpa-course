package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import com.higherAchievers.springdatajpacourse.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setPrice(new BigDecimal(1000));
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal(2000));
        product2.setImageUrl("image2.png");
        product2.setSku("BCDE");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void fetchProductCategory(){
        ProductCategory category = productCategoryRepository.findById(1L).get();

        // calling .getProducts to category will fetch the products despite it being initialized to lazy
        // at the entity class.
        // Note: this will work only if the test method has @Transactional annotation
        System.out.println(category.getProducts());
    }

}
