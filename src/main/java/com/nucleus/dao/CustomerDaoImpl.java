package com.nucleus.dao;


import com.nucleus.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    static HashMap<Integer,Customer> mapOfCustomerIdToCustomer=getMapCustomerIdToCustomer();

    public CustomerDaoImpl() {
        super();

        if(mapOfCustomerIdToCustomer==null)
        {
            mapOfCustomerIdToCustomer=new HashMap<Integer, Customer>();
            Customer customer1=new Customer(101, "Rohit","rohit@gmail.com");
            Customer customer2=new Customer(102, "Rizwan","rizwan@gmail.com");
            Customer customer3=new Customer(103, "Shikhar","shikhar@gmail.com");
            Customer customer4=new Customer(104, "Ishan","ishan@gmail.com");

            mapOfCustomerIdToCustomer.put(101,customer1);
            mapOfCustomerIdToCustomer.put(102,customer2);
            mapOfCustomerIdToCustomer.put(103,customer3);
            mapOfCustomerIdToCustomer.put(104,customer4);
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList(mapOfCustomerIdToCustomer.values());
        return customerList;    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer= mapOfCustomerIdToCustomer.get(customerId);
        return customer;    }

    @Override
    public Customer addCustomer(Customer customer) {
        mapOfCustomerIdToCustomer.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getCustomerId()<=0)
            return null;
        mapOfCustomerIdToCustomer.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Boolean deleteCustomer(int customerId) {
        if(!mapOfCustomerIdToCustomer.containsKey(customerId))
            return false;
        mapOfCustomerIdToCustomer.remove(customerId);
       return true;
    }
    public static HashMap<Integer, Customer> getMapCustomerIdToCustomer() {
        return mapOfCustomerIdToCustomer;
    }
}
