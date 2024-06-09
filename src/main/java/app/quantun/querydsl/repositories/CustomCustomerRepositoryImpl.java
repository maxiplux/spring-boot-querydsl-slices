package app.quantun.querydsl.repositories;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.projection.CustomerFullName;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Objects;

public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findCustomerCustom(String firstName, String lastName) {
        return (Customer) entityManager.createQuery("FROM Customer c WHERE c.firstName = :firstName and c.lastName = :lastName")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    @Override
    public CustomerFullName findFirstByOrderByFirstNameDesc() {
        return null;
    }

    @PostConstruct
    public void postConstruct() {
        Objects.requireNonNull(entityManager);
    }
}
