package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Address;
import com.higherAchievers.springdatajpacourse.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {

    @Autowired
    private  AddressRepository addressRepository;

    @Test
    void saveAddressMethod(){

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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod(){
        Address address = addressRepository.findById(1L).get();
        address.setZipCode("23456");

        address.getOrder().setStatus("DELIVERED");

        addressRepository.save(address);
    }

    @Test
    void fetchAddressMethod(){
        Address address = addressRepository.findById(1L).get();
    }

    @Test
    void deleteAddressMethod(){
        addressRepository.deleteById(1L);
    }


}
