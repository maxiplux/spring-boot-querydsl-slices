package app.quantun.querydsl.repositories;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.projection.CustomerFullName;
import app.quantun.querydsl.repositories.projection.CustomerInfo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>, CustomCustomerRepository, QuerydslPredicateExecutor<Customer> {


    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findAllByLastName(String lastName);

    List<Customer> findAllByFirstName(String firstName);

    Optional<Customer> findFirstByLastNameOrderByFirstNameDesc(String lastName);

    Customer findFirstByOrderByFirstNameAsc();

    Stream<Customer> readAllByOrderById();

    /*
    @Query("select p from Customer p order by p.id asc limit 1")
    Customer fetchFirstCustomerUsingQuery();
    */

    Customer searchUsingNamedQuery(String lastName);

    CustomerFullName findFirstByOrderByFirstNameDesc();

    CustomerInfo findFirstByOrderByLastNameAsc();
}
