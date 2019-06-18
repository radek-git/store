package com.radek.store.repository;

import com.radek.store.entity.users.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsername(String username);

    ResponseEntity<Object> deleteByUsername(String username);

    List<Employee> findAllByStore_Id(Long id, Pageable pageable);
}
