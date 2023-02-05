package org.sid.customerservice;

import org.sid.customerservice.Entities.Customer;
import org.sid.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
        customerRepository.saveAll(List.of(
                Customer.builder().name("meryem").email("meryem19@gmail.com").build(),
                Customer.builder().name("youssef").email("youssef@gmail.com").build(),
                Customer.builder().name("ghali").email("ghali@gmail.com").build()
                )
        );
        customerRepository.findAll().forEach(c->{
            System.out.println(c);
        });
        };

    }

}
