package com.nucleus.dao;


import com.nucleus.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(int customerId);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(int customerId);
}
