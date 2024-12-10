package com.example.demo.service;


import com.example.demo.Request.CustomerRegistrationRequest;
import com.example.demo.Request.CustomerUpdateRequest;
import com.example.demo.entity.Customer;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.RequestValidationException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final  CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Customer> getCustomers() {
        return customerDao.selectAllCustomers();
    };

    public Customer getCustomerById(Integer userId) {
        return customerDao.selectCustomerById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public void addCustomer(CustomerRegistrationRequest request) {

        if(customerDao.existsCustomerByEmail(request.email())){
            throw new DuplicateResourceException("Customer already exists");
        }

        //ADD
        Customer customer = new Customer(
                request.name(),
                request.age(),
                request.email()
        );

        customerDao.insertCustomer(customer);
    }


    public void deleteCustomerById(Integer userId) {
        if(!customerDao.existsCustomerById(userId)){
            throw new ResourceNotFoundException(
                    "Customer with id %s not found".formatted(userId)
            );
        }
        customerDao.deleteCustomerById(userId);
    }


    public void updateUserById(Integer userId, CustomerUpdateRequest request) {
        Customer customer = getCustomerById(userId);

        boolean update=false;

        if(request.name()!=null && !customer.getName().equals(request.name())){
            update=true;
            customer.setName(request.name());
        }

        if(request.email()!=null && !customer.getName().equals(request.email())){
            if(customerDao.existsCustomerByEmail(request.email())){
                throw new DuplicateResourceException("Customer already exists");
            }
            update=true;
            customer.setEmail(request.email());
        }

        if(request.age()!=null && !customer.getAge().equals(request.age())){
            update=true;
            customer.setAge(request.age());
        }

        if(!update){
            throw new RequestValidationException("no data changes found");
        }
        customerDao.updateUser(customer);


    }
}
