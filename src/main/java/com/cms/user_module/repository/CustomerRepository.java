package com.cms.user_module.repository;

import com.cms.user_module.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByUsername(String name);
}
