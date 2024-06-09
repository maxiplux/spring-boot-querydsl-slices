package app.quantun.querydsl.repositories.dtos;

import app.quantun.querydsl.models.QCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerSearchDTO {

    @Size(max = 50, min = 5, message = "First name must be between 5 and 50 characters")
    private String firstName;

    @Size(max = 100, min = 5, message = "Last name must be between 5 and 50 characters")
    private String lastName;

    @Email
    @Size(max = 256, min = 5, message = "Email must be between 5 and 50 characters")
    private String email;


    private Integer age;

    @JsonIgnore
    public Predicate getPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        QCustomer qCustomer = QCustomer.customer;
        if (firstName != null) {
            builder.and(qCustomer.firstName.equalsIgnoreCase(firstName));
        }
        if (lastName != null) {
            builder.and(qCustomer.lastName.equalsIgnoreCase(lastName));
        }
        return builder;
    }

}
