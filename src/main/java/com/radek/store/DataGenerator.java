package com.radek.store;

import com.radek.store.entity.Role;
import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;
import com.radek.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private OrderRepository orderRepository;
    private PositionRepository positionRepository;
    private ProductRepository productRepository;
    private RoleRepository roleRepository;
    private StoreRepository storeRepository;


    @Autowired
    public DataGenerator(UserRepository userRepository, EmployeeRepository employeeRepository,
                         CustomerRepository customerRepository, BrandRepository brandRepository,
                         CategoryRepository categoryRepository, OrderRepository orderRepository,
                         PositionRepository positionRepository, ProductRepository productRepository,
                         RoleRepository roleRepository, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.positionRepository = positionRepository;
        this.productRepository = productRepository;
        this.roleRepository = roleRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//
//        Customer customer = Customer.builder()
//                .name("Jan")
//                .surname("Nowak")
//                .username("jnowak")
//                .email("jnowak@wp.pl")
//                .password("$2a$10$8lM7EkU28dbwN59NxSQGNe4/cuJu9bc822rSfFAVw69blKyJbMgbq")
//                .phoneNumber("88788868768")
//                .street("Rybia 5")
//                .city("Płońsk")
//                .postalCode("88981")
//                .build();
//
//
//        customer.getRoles().add(roleUser);
//
//        customerRepository.save(customer);
//


    }
}
