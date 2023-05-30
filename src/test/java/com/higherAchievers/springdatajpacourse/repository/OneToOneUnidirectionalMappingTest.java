package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Address;
import com.higherAchievers.springdatajpacourse.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setZipCode("12345");
        address.setStreet("Olodi");
        address.setCity("Apapa");

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void getOrderMethod(){
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }

    @Test
    void updateOrderMethod(){
        Order order = orderRepository.findById(1L).get();

        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("23456");
        orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }

}






