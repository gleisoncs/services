package com.yourdesire;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourdesire.domain.Customer;
import com.yourdesire.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@SpringBootTest
public class CustomerAPITest {

    @Autowired
    private MockMvc mockMvc;

//    
//    @Value("${spring.data.rest.basePath}")
//    private String restBasePath;

    private String customerURI;

    @Before
    public void init() {
        customerURI = String.format("/%s/", CustomerRepository.ROOTPATH);
    }

    
    @Test
    public void getEmptyCustomerList() throws Exception {
        mockMvc.perform(get(customerURI)).andExpect(status().isOk());

    }

    @Test
    public void addCustomer() throws Exception {
        UUID uuid = UUID.randomUUID();
        mockMvc.perform(
                post(customerURI).contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(Customer.builder().UUID(uuid.toString())
                                .firstName("Zé").lastName("das Couves").username("zecouves").build())))
                .andExpect(status().isCreated());

        mockMvc.perform(get(customerURI)).andExpect(status().isOk())
        .andExpect(jsonPath("_embedded.customer[0].uuid").value(uuid.toString()));

    }

}
