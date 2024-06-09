package app.quantun.querydsl.services;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.dtos.CustomerSearchDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CustomerService {
    public Slice<Customer> findCustomers(CustomerSearchDTO searchDTO, Pageable pageable);
}
