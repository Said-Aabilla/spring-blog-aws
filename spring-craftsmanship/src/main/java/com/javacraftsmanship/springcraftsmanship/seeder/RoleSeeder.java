package com.javacraftsmanship.springcraftsmanship.seeder;

import com.javacraftsmanship.springcraftsmanship.entity.Role;
import com.javacraftsmanship.springcraftsmanship.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.javacraftsmanship.springcraftsmanship.utils.AppRoles.ROLE_ADMIN;
import static com.javacraftsmanship.springcraftsmanship.utils.AppRoles.ROLE_USER;

@Component
public class RoleSeeder implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    private void seedRoles() {
        // Check if roles already exist, and if not, create and save them
        if (roleRepository.findByName(ROLE_ADMIN).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(ROLE_ADMIN);
            Role savedRole =  roleRepository.save(adminRole);
        }

        if (roleRepository.findByName(ROLE_USER).isEmpty()) {
            Role userRole = new Role();
            userRole.setName(ROLE_USER);
            roleRepository.save(userRole);
        }
    }
}
