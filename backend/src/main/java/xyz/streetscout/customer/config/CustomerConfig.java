package xyz.streetscout.customer.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import xyz.streetscout.customer.entity.Customer;
import xyz.streetscout.customer.repository.CustomerRepository;

@Profile("!prod")
@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {

        return args -> {
            createCustomer(customerRepository);
        };
    }

    private static void createCustomer(CustomerRepository customerRepository) {
        Customer customer = new Customer();
        customer.setName("Mark Jacobs");
        customer.setEmail("mark@jacobs.com");
        customerRepository.save(customer);
    }
}
