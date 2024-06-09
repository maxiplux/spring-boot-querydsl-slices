package app.quantun.querydsl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@Slf4j
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)

public class QuerydslApplication implements CommandLineRunner {

//    @Autowired
//    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }
//    @Bean
//    CustomCustomerRepository getCustomCustomerRepository() {
//        return new CustomCustomerRepositoryImpl();
//    }


    @Override
    public void run(String... strings) throws Exception {
//        log.info(String.valueOf(getCustomCustomerRepository().findCustomerCustom("Thomas", "Edison")));
//
//        Customer customer1 = new Customer();
//        customer1.setFirstName("Anshul");
//        customer1.setLastName("Bansal");
//
////        this.customerRepository.save(customer1);
//
//        QCustomer qCustomer = QCustomer.customer;
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        if ( 1==1) {
//            booleanBuilder.and(qCustomer.lastName.startsWithIgnoreCase("Edison"));
//        }
//        if ( 2!=1) {
//            booleanBuilder.and(qCustomer.firstName.equalsIgnoreCase("Thomas"));
//        }
//
//
//
//
//
//        log.info(String.valueOf(customerRepository.findAll(booleanBuilder, PageRequest.of(0, 10, Sort.by("firstName").descending()  ))));;


    }
}
