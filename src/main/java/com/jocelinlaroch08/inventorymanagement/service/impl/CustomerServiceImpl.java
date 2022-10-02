package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Customer;
import com.jocelinlaroch08.inventorymanagement.repository.CustomerRepository;
import com.jocelinlaroch08.inventorymanagement.service.CustomerService;
import com.jocelinlaroch08.inventorymanagement.validator.CustomerValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = CustomerValidator.validate(customerDto);

        if(!errors.isEmpty()) {
            log.error("Customer is not valid {}", customerDto);
            throw new InvalidEntityException("Customer is not valid", ErrorCode.CUSTOMER_NOT_VALID, errors);
        }

        Customer savedCustomer = customerRepository.save(CustomerDto.toEntity(customerDto));

        return CustomerDto.fromEntity(savedCustomer);
    }

    @Override
    public CustomerDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<Customer> customer = customerRepository.findById(id);

        CustomerDto customerDto = CustomerDto.fromEntity(customer.get());

        return Optional.of(customerDto).orElseThrow(() -> new EntityNotFoundException("No customer found", ErrorCode.CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream().map(CustomerDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        customerRepository.deleteById(id);
    }
}
