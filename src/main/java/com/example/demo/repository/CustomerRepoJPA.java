package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository(value = "JPA")
public class CustomerRepoJPA implements CustomerDao{

    private final CustomerRepository customerRepository;

    public CustomerRepoJPA(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public boolean existsCustomerByEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public boolean existsCustomerById(Integer id) {
        return customerRepository.existsCustomerById(id);
    }

    @Override
    public void deleteCustomerById(Integer userId) {
        customerRepository.deleteById(userId);
    }

    @Override
    public void updateUser(Customer customer) {
        customerRepository.save(customer);
    }


}
