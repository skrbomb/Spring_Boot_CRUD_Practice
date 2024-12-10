package com.example.demo.repository;

import com.example.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsCustomerByEmail(String email);
    boolean existsCustomerById(Integer id);

    void deleteCustomerById(Integer userId);


    void updateUser(Customer customer);
}
