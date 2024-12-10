package com.example.demo.controller;

import com.example.demo.Request.CustomerRegistrationRequest;
import com.example.demo.Request.CustomerUpdateRequest;
import com.example.demo.Response.GreetResponse;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Person;
import com.example.demo.record.Greet;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/greet")
    public GreetResponse greet(@RequestParam(value = "name",required = false) String name){
        String greetMessage=name==null||name.isBlank()?"Hello World!":"Hello "+name+"!";
        GreetResponse response=new GreetResponse(
                greetMessage,
                List.of("Java","Golang","Javascipt"),
                new Person("Alex",18,30_000)
        );
        return response;
    }

    @GetMapping("/all")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{userId}")
    public Customer getCustomerById(@PathVariable("userId") Integer userId){
        return customerService.getCustomerById(userId);
    }

    @PostMapping("/register")
    public void addCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteCustomer(@PathVariable("userId") Integer userId){
        customerService.deleteCustomerById(userId);
    }

    @PostMapping("/update/{userId}")
    public  void updateCustomer(@PathVariable("userId") Integer userId,
                                @RequestBody CustomerUpdateRequest request){
        customerService.updateUserById(userId,request);
    }
}
