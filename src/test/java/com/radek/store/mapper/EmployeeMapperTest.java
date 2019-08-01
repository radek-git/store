package com.radek.store.mapper;

import com.radek.store.SampleDataGenerator;
import com.radek.store.dto.customers.AdminCustomerDTO;
import com.radek.store.dto.employees.AdminEmployeeDTO;
import com.radek.store.dto.employees.AuthEmployeeDTO;
import com.radek.store.dto.employees.EmployeeDTO;
import com.radek.store.dto.employees.EmployeeEmployeeDTO;
import com.radek.store.entity.Position;
import com.radek.store.entity.Store;
import com.radek.store.entity.users.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = new EmployeeMapperImpl();


    @Test
    public void shouldMapEmpToDTO() {
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);

        EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);

        assertEquals(employee.getName(), employeeDTO.getName());
        assertEquals(employee.getSurname(), employeeDTO.getSurname());
        assertEquals(employee.getUsername(), employeeDTO.getUsername());
    }

    @Test
    public void shouldMapEmpListToDTO() {
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee employee1 = SampleDataGenerator.getEmployee1(store, position);
        Employee employee2 = SampleDataGenerator.getEmployee1(store, position);

        List<Employee> employees = List.of(employee1, employee2);
        List<EmployeeDTO> employeeDTOS = employeeMapper.toDTO(employees);

        assertEquals(employee1.getName(), employeeDTOS.get(0).getName());
        assertEquals(employee2.getName(), employeeDTOS.get(1).getName());
        assertEquals(employee1.getUsername(), employeeDTOS.get(0).getUsername());
        assertEquals(employee2.getUsername(), employeeDTOS.get(1).getUsername());
    }

    @Test
    public void shouldMapEmpToAuthEmpDTO() {
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);

        AuthEmployeeDTO authEmployeeDTO = employeeMapper.toAuthEmployeeDTO(employee);

        assertEquals(employee.getName(), authEmployeeDTO.getName());
        assertEquals(employee.getSurname(), authEmployeeDTO.getSurname());
        assertEquals(employee.getUsername(), authEmployeeDTO.getUsername());
        assertEquals(employee.getStore().getId(), authEmployeeDTO.getStoreId());
    }


    @Test
    public void shouldMapToAdminEmpDTO() {
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee employee1 = SampleDataGenerator.getEmployee1(store, position);

        AdminEmployeeDTO adminEmployeeDTO = employeeMapper.toAdminEmployeeDTO(employee1);

        assertEquals(employee1.getName(), adminEmployeeDTO.getName());
        assertEquals(employee1.getSurname(), adminEmployeeDTO.getSurname());
        assertEquals(employee1.getUsername(), adminEmployeeDTO.getUsername());
        assertEquals(employee1.getStore().getId(), adminEmployeeDTO.getStoreId());
        assertEquals(employee1.getPosition().getName(), adminEmployeeDTO.getPosition());
    }


    @Test
    public void shouldMapToEmpEmpDTO() {
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee employee1 = SampleDataGenerator.getEmployee1(store, position);

        EmployeeEmployeeDTO employeeEmployeeDTO = employeeMapper.toEmployeeEmployeeDTO(employee1);

        assertEquals(employee1.getName(), employeeEmployeeDTO.getName());
        assertEquals(employee1.getSurname(), employeeEmployeeDTO.getSurname());
        assertEquals(employee1.getUsername(), employeeEmployeeDTO.getUsername());

    }
}
