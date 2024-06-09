package app.quantun.querydsl.services;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.models.QCustomer;
import app.quantun.querydsl.repositories.CustomerSliceRepository;
import app.quantun.querydsl.repositories.dtos.CustomerSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerSliceRepository customerSliceRepository;

    @Override
    public Slice<Customer> findCustomers(CustomerSearchDTO searchDTO, Pageable pageable) {
        return this.customerSliceRepository.findAllWithoutCount(QCustomer.customer, searchDTO.getPredicate(), pageable);
        // return this.customerRepository.findAll(searchDTO.getPredicate(),pageable);
    }
}
