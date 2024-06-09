package app.quantun.querydsl.repositories;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.projection.customrepositories.GenericRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSliceRepository extends JpaRepository<Customer, Long>, GenericRepository<Customer> {

    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    Slice<Customer> customeSearch(Predicate predicate, Pageable pageable);


    Slice<Customer> findAllByIdIsNot(Long id, Predicate predicate, Pageable pageable);

    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    Slice<Customer> getAll(Predicate predicate, Pageable pageable);


}
