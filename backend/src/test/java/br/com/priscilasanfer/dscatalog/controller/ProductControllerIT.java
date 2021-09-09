package br.com.priscilasanfer.dscatalog.controller;

import br.com.priscilasanfer.dscatalog.dto.ProductDTO;
import br.com.priscilasanfer.dscatalog.factory.Factory;
import br.com.priscilasanfer.dscatalog.repositories.ProductRepository;
import br.com.priscilasanfer.dscatalog.tests.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TokenUtil tokenUtil;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalProduct;
    private String username;
    private String password;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistingId = 200L;
        countTotalProduct = 25L;
        username = "alex@gmail.com";
        password = "123456";
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

    @Test
    public void updateShouldReturnProductWhenIdExistsWithUserLogged() throws Exception {
        ProductDTO productDTO = Factory.createProductDto();
        productDTO.setDescription("Teste");

        String jsonBody = objectMapper.writeValueAsString(productDTO);

        String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

        String expectedName = productDTO.getName();
        String expectedDescription = productDTO.getDescription();
        Long expectedId = productDTO.getId();

        mockMvc.perform(put("/products/{id}", existingId)
                .header("Authorization", "Bearer " + accessToken)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectedId))
                .andExpect(jsonPath("$.name").value(expectedName))
                .andExpect(jsonPath("$.description").value(expectedDescription));
    }

    @Test
    public void updateShouldThrowNotFoundExceptionWhenIdDoesNotExistsWithUserLogged() throws Exception {
        ProductDTO productDTO = Factory.createProductDto();
        String jsonBody = objectMapper.writeValueAsString(productDTO);

        String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

        mockMvc.perform(put("/products/{id}", nonExistingId)
                .header("Authorization", "Bearer " + accessToken)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
