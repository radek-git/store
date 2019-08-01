package com.radek.store.mapper;

import com.radek.store.SampleDataGenerator;
import com.radek.store.dto.customers.AdminCustomerDTO;
import com.radek.store.dto.customers.CustomerDTO;
import com.radek.store.entity.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class CustomerMapperTest {

    private CustomerMapper customerMapper = new CustomerMapperImpl();


    @Test
    public void shouldMapCustomerToDTO() {
        Customer customer = SampleDataGenerator.getCustomer();
        CustomerDTO customerDTO = customerMapper.toDTO(customer);

        assertEquals("Jan", customerDTO.getName());
    }

    @Test
    public void shouldMapCustomersListToDTO() {
        Customer customer1 = SampleDataGenerator.getCustomer();
        Customer customer2 = SampleDataGenerator.getCustomer();

        List<Customer> customers = List.of(customer1, customer2);

        List<CustomerDTO> customerDTOS = customerMapper.toDTO(customers);

        assertEquals(customer1.getName(), customerDTOS.get(0).getName());
        assertEquals(customer2.getName(), customerDTOS.get(1).getName());
        assertEquals("Nowak", customerDTOS.get(0).getSurname());
        assertEquals("Nowak", customerDTOS.get(1).getSurname());
    }

    @Test
    public void shouldMapToAdminCustomerDTO() {
        Customer customer = SampleDataGenerator.getCustomer();
        AdminCustomerDTO adminCustomerDTO = customerMapper.toAdminCustomerDTO(customer);

        assertEquals("Jan", adminCustomerDTO.getName());
        assertEquals("Nowak", adminCustomerDTO.getSurname());
        assertEquals(customer.getUsername(), adminCustomerDTO.getUsername());
        assertEquals(customer.getCity(), adminCustomerDTO.getCity());
        assertEquals(customer.getStreet(), adminCustomerDTO.getStreet());
        assertEquals(customer.getPostalCode(), adminCustomerDTO.getPostalCode());
    }


    @Test
    public void shouldMapCustomersListToAdminDTO() {
        Customer customer1 = SampleDataGenerator.getCustomer();
        Customer customer2 = SampleDataGenerator.getCustomer();

        List<Customer> customers = List.of(customer1, customer2);
        List<AdminCustomerDTO> adminCustomerDTOS = customerMapper.toAdminCustomerDTO(customers);

        assertEquals(customer1.getName(), adminCustomerDTOS.get(0).getName());
        assertEquals(customer2.getName(), adminCustomerDTOS.get(1).getName());
        assertEquals(customer1.getUsername(), adminCustomerDTOS.get(0).getUsername());
        assertEquals(customer2.getUsername(), adminCustomerDTOS.get(1).getUsername());
        assertEquals(customer1.getCity(), adminCustomerDTOS.get(0).getCity());
        assertEquals(customer2.getCity(), adminCustomerDTOS.get(1).getCity());
    }
}
