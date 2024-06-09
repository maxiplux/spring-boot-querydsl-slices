package app.quantun.querydsl.controllers;

import app.quantun.querydsl.repositories.dtos.CustomerSearchDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
