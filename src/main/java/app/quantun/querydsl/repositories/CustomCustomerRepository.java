package app.quantun.querydsl.repositories;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.projection.CustomerFullName;

public interface CustomCustomerRepository {
    Customer findCustomerCustom(String firstName, String lastName);

    CustomerFullName findFirstByOrderByFirstNameDesc();
}
