package com.cms.user_module.service;

import com.cms.user_module.Interface.CustomerService;
import com.cms.user_module.dto.CustomerRequest;
import com.cms.user_module.dto.CustomerResponse;
import com.cms.user_module.model.Customer;
import com.cms.user_module.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

       Customer customer=new Customer();
       customer.setEmail(customerRequest.getEmail());
       customer.setUsername(customerRequest.getUsername());
       customer.setPassword(customerRequest.getPassword());

       Customer savedCustomer = customerRepository.save(customer);
       CustomerResponse customerResponse=new CustomerResponse();
       customerResponse.setToken(customerResponse.getToken());
       return customerResponse;

    }

    public List<Customer> findCustomerByUserName(String name) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findByUsername(name));
        if(optionalCustomer.isPresent()){
            List<Customer> customerList = optionalCustomer
                    .map(Collections::singletonList) // Converts to List
                    .orElse(Collections.emptyList());
            return customerList;}
        else{
            throw new RuntimeException("not found username");
        }
    }

}
