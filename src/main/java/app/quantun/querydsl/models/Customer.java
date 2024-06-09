package app.quantun.querydsl.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;

@Data
@Entity
@NamedQuery(name = "Customer.searchUsingNamedQuery",
        query = "select c from Customer c where c.lastName = ?1 order by c.firstName desc limit 1")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends AbstractAggregateRoot<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth = LocalDate.now();


}
