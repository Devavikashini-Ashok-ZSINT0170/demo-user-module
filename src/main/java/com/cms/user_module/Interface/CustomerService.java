package com.cms.user_module.Interface;

import com.cms.user_module.dto.CustomerRequest;
import com.cms.user_module.dto.CustomerResponse;
import com.cms.user_module.model.Customer;
import java.util.List;

public interface CustomerService {
    public CustomerResponse addCustomer(CustomerRequest customerRequest);

    public List<Customer> findCustomerByUserName(String name);

}
