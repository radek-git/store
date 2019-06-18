package com.radek.store.specification;


import com.radek.store.entity.users.Customer;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@And({
        @Spec(path = "name", spec = Equal.class),
        @Spec(path = "surname", spec = Equal.class),
        @Spec(path = "username", spec = Equal.class)
})
public interface CustomerSpecification extends Specification<Customer> {
}
