package org.example.interndemo;

import org.example.interndemo.Entities.Client;
import org.example.interndemo.Entities.Product;
import org.example.interndemo.Repositories.ClientRepository;
import org.example.interndemo.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InternDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternDemoApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository, ProductRepository productRepository) {
        return args -> {

            Client c1 = clientRepository.save(
                    Client.builder().firstName("John").lastName("Doe").email("john@gmail.com").build()
            );

            Client c2 = clientRepository.save(
                    Client.builder().firstName("Sarah").lastName("Smith").email("sarah@gmail.com").build()
            );

            productRepository.save(
                    Product.builder().name("Laptop").price(899.99).quantity(3).client(c1).build()
            );

            productRepository.save(
                    Product.builder().name("Phone").price(499.99).quantity(10).client(c1).build()
            );

            productRepository.save(
                    Product.builder().name("Tablet").price(299.99).quantity(5).client(c2).build()
            );

            System.out.println("✔ Sample Clients & Products created!");
        };
}
}
