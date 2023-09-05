package org.SpringBoot.onus;


import org.SpringBoot.onus.Controllers.UserController;
import org.SpringBoot.onus.Models.Customer;
import org.SpringBoot.onus.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.SpringBoot")
@EntityScan(basePackages = "org.SpringBoot.onus")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        UserController userController = new UserController(userRepository);
        Customer user = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        Customer user2 = new Customer("Tarik","Ibrahim", "Daoud", "Ansara");
        return args -> {
            userRepository.save(user);
            userController.addUser(user);
            userRepository.save(user2);
            userController.addUser(user2);
        };
    }
}


