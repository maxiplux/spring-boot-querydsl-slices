package app.quantun.querydsl.controllers;

import app.quantun.querydsl.models.Customer;
import app.quantun.querydsl.repositories.dtos.CustomerSearchDTO;
import app.quantun.querydsl.repositories.projection.customrepositories.GenericRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
class HomeControllerTest {



    @Autowired
    private HomeController customerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void searchCustomers() throws Exception {




        CustomerSearchDTO searchDTO = new CustomerSearchDTO("Albert", "Jones", "john.doe@example.com", 30);
        ObjectMapper objectMapper = new ObjectMapper();
        String searchDTOJson = objectMapper.writeValueAsString(searchDTO);


            mockMvc.perform(post("/api/v1/customers/search?page=0&size=10")
                            .content(searchDTOJson)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk());

    }
}
