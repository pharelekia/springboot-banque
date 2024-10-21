package com.example.springboot_intro.service;

import com.example.springboot_intro.entity.Customer;
import com.example.springboot_intro.exception.CustomerNotFoundException;
import com.example.springboot_intro.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with "+id+" not found"));
    }

    public Customer saveCustomer(Customer customerInput){
        return customerRepository.save(customerInput);
    }

    public Customer updateCustomer(Long id, Customer customerInput){
        Customer customer = getCustomer(id);
        customer.setName(customerInput.getName());
        return customerRepository.save(customer);
    }

    public String deleteCustomer(Long id){
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        return "Customer deleted";
    }
}
