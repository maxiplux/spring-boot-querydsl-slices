package app.quantun.querydsl.controllers;

import app.quantun.querydsl.exceptions.CustomerNotFoundException;
import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.dtos.CustomerSearchDTO;
import app.quantun.querydsl.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/search")
    public ResponseEntity<?> searchCustomers(@Valid @RequestBody CustomerSearchDTO searchDTO,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size

    ) {

        if (page == 100) {
            throw new CustomerNotFoundException("Invalid Page Number");
        }
        Pageable pageable = PageRequest.of(page, size);

        Slice<Customer> customers = customerService.findCustomers(searchDTO, pageable);

        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customers);
    }
}
