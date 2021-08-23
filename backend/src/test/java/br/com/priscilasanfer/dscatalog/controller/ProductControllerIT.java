package br.com.priscilasanfer.dscatalog.controller;

import br.com.priscilasanfer.dscatalog.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalProduct;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistingId = 200L;
        countTotalProduct = 25L;
    }

    @Test
    public void findAllShouldReturnSortedPageWhenSortByName() throws Exception {
        mockMvc.perform(get("/products?page=0&sort=name,asc&size=12")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(countTotalProduct))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content[0].name").value("Macbook Pro"))
                .andExpect(jsonPath("$.content[1].name").value("PC Gamer"))
                .andExpect(jsonPath("$.content[2].name").value("PC Gamer Alfa"));
    }
}
