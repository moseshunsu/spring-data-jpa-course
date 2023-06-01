package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Role;
import com.higherAchievers.springdatajpacourse.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole(){
        User user = new User();
        user.setFirstName("Moses");
        user.setLastName("Hunsu");
        user.setEmail("hunsumoses7@gmail.com");
        user.setPassword("dummy");

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("dummy");

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");

        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(admin);

        user.getRoles().add(roleAdmin);
        admin.getRoles().add(roleAdmin);

        roleRepository.save(roleAdmin);

    }

    @Test
    void fetchRole(){
        List<Role> roles = roleRepository.findAll();
        roles.forEach(role -> {
            System.out.println(role.getName());
            role.getUsers().forEach(user -> {
                System.out.println(user.getFirstName());
            });
        });
    }

}
