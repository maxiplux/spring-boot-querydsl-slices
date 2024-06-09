package app.quantun.querydsl.repositories.dsl;

import app.quantun.querydsl.models.Customer;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;


public class QCustomer extends EntityPathBase<Customer> {
    public static final QCustomer customer = new QCustomer("Customer");
    private static final long serialVersionUID = 1828420791L;
    public final StringPath firstName = this.createString("firstName");
    public final NumberPath<Long> id = this.createNumber("id", Long.class);
    public final StringPath lastName = this.createString("lastName");


    public QCustomer(String variable) {
        super(Customer.class, variable);
    }
}
