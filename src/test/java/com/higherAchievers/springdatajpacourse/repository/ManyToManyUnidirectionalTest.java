package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Role;
import com.higherAchievers.springdatajpacourse.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveUser(){
        User user = new User();
        user.setFirstName("Moses");
        user.setLastName("Hunsu");
        user.setEmail("hunsumoses@gmail.com");
        user.setPassword("dummy");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);
    }

    @Test
    void updateUser(){
        User user = userRepository.findById(1L).get();
        user.setFirstName("Mos");
        user.setEmail("hmoses@gmail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().add(roleUser);

        userRepository.save(user);
    }

    @Test
    void fetchUser(){
        User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach(role -> System.out.println(role.getName()));
    }

    @Test
    void deleteUser(){
        userRepository.deleteById(1L);
    }
}
