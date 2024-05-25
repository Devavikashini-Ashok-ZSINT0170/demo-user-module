package com.cms.user_module.controller;


import com.cms.user_module.Interface.CustomerService;
import com.cms.user_module.dto.CustomerRequest;
import com.cms.user_module.dto.CustomerResponse;
import com.cms.user_module.dto.LoginRequest;
import com.cms.user_module.model.Customer;
import com.cms.user_module.service.CustomerUserDetailsService;
import com.cms.user_module.service.JwtUtilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtUtilityServiceImpl jwtUtilityService;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @PostMapping("/customer/add")
    public CustomerResponse addCustomer(@RequestBody  CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @PostMapping("/login")
    public String createUser(@RequestBody LoginRequest login) {
        if (customerUserDetailsService.loadUserByUsername(login.getUsername()) == null) {
            return "Invalid credentials";
        }
        return jwtUtilityService.generateToken(login.getUsername());
    }

    @GetMapping("/registration/{username}")
    public List<Customer> findCustomerByUsername(@PathVariable("username") String userName){
        return customerService.findCustomerByUserName(userName);
    }



}
