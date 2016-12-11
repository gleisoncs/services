package com.yourdesire.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yourdesire.domain.Customer;

@RepositoryRestResource(path = CustomerRepository.ROOTPATH, collectionResourceRel = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
    
    public static final String ROOTPATH = "customer";

}
