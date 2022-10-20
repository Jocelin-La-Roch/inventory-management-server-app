package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderDto;
import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderLineDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Article;
import com.jocelinlaroch08.inventorymanagement.model.Customer;
import com.jocelinlaroch08.inventorymanagement.model.CustomerOrder;
import com.jocelinlaroch08.inventorymanagement.model.CustomerOrderLine;
import com.jocelinlaroch08.inventorymanagement.repository.ArticleRepository;
import com.jocelinlaroch08.inventorymanagement.repository.CustomerOrderLineRepository;
import com.jocelinlaroch08.inventorymanagement.repository.CustomerOrderRepository;
import com.jocelinlaroch08.inventorymanagement.repository.CustomerRepository;
import com.jocelinlaroch08.inventorymanagement.service.CustomerOrderService;
import com.jocelinlaroch08.inventorymanagement.validator.CustomerOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;
    private CustomerRepository customerRepository;
    private ArticleRepository articleRepository;
    private CustomerOrderLineRepository customerOrderLineRepository;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository,
            CustomerRepository customerRepository, ArticleRepository articleRepository, CustomerOrderLineRepository customerOrderLineRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.articleRepository = articleRepository;
        this.customerOrderLineRepository = customerOrderLineRepository;
    }


    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        List<String> errors = CustomerOrderValidator.validate(customerOrderDto);
        if (!errors.isEmpty()) {
            log.error("Order is not valid {}", customerOrderDto);
            throw new InvalidEntityException("Order is not valid", ErrorCode.CUSTOMER_ORDER_NOT_VALID, errors);
        }

        Optional<Customer> customer = customerRepository.findById(customerOrderDto.getCustomerDto().getId());

        if (customer.isEmpty()) {
            log.warn("Customer not found");
            throw new EntityNotFoundException("", ErrorCode.CUSTOMER_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (customerOrderDto.getLineDtoList() != null) {
            customerOrderDto.getLineDtoList().forEach(customerOrderLineDto -> {
                if (customerOrderLineDto.getArticleDto() != null) {
                    Optional<Article> article = articleRepository.findById(customerOrderLineDto.getArticleDto().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Article with id : " + customerOrderLineDto.getArticleDto().getId() + " not found");
                    }
                } else {
                    articleErrors.add("Article can't be null");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("Articles not found");
            throw new InvalidEntityException("Some articles not found", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
        }

        CustomerOrder savedCustomerOrder = customerOrderRepository.save(CustomerOrderDto.toEntity(customerOrderDto));

        // Because on can have no line
        if (customerOrderDto.getLineDtoList() != null) {
            customerOrderDto.getLineDtoList().forEach(customerOrderLineDto -> {
                CustomerOrderLine customerOrderLine = CustomerOrderLineDto.toEntity(customerOrderLineDto);
                customerOrderLine.setOrder(savedCustomerOrder);
                customerOrderLineRepository.save(customerOrderLine);
            });
        }

        return CustomerOrderDto.fromEntity(savedCustomerOrder);
    }

    @Override
    public CustomerOrderDto findById(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return null;
        }
        return customerOrderRepository.findById(integer).map(CustomerOrderDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No order found", ErrorCode.CUSTOMER_ORDER_NOT_FOUND));
    }

    @Override
    public CustomerOrderDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("ID is null");
            return null;
        }

        return customerOrderRepository.findByCode(code).map(CustomerOrderDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No order found", ErrorCode.CUSTOMER_ORDER_NOT_FOUND));
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return customerOrderRepository.findAll().stream().map(CustomerOrderDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return;
        }
        customerOrderRepository.deleteById(integer);
    }
}
