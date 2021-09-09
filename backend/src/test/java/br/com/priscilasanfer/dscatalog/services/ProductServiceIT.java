package br.com.priscilasanfer.dscatalog.services;

import br.com.priscilasanfer.dscatalog.dto.ProductDTO;
import br.com.priscilasanfer.dscatalog.repositories.ProductRepository;
import br.com.priscilasanfer.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // da rollback dps de cada teste
public class ProductServiceIT {

    @Autowired
    private ProductService service;

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
    public void deleteShouldDeleteResourceWhenIdExists() {
        service.delete(existingId);
        assertEquals(countTotalProduct - 1, repository.count());
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesExists() {
        assertThrows(ResourceNotFoundException.class, () -> service.delete(nonExistingId));
        assertEquals(countTotalProduct, repository.count());
    }

    @Test
    public void findAllPageableShouldReturnPage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProductDTO> result = service.find(0L,"", pageable);

        assertNotNull(result);
        assertEquals(0, result.getNumber());
        assertEquals(10, result.getSize());
        assertEquals(countTotalProduct, result.getTotalElements());

    }

    @Test
    public void findAllPageableShouldReturnEmptyPageWhenPageDoesNotExist() {
        Pageable pageable = PageRequest.of(50, 10);
        Page<ProductDTO> result = service.find(0L, "", pageable);

        assertTrue(result.isEmpty());
    }


    @Test
    public void findAllPageableShouldReturnOrderedWhenSortByName() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<ProductDTO> result = service.find(0L, "",  pageable);

        assertFalse(result.isEmpty());
        assertEquals("Macbook Pro", result.getContent().get(0).getName());
        assertEquals("PC Gamer", result.getContent().get(1).getName());
        assertEquals("PC Gamer Alfa", result.getContent().get(2).getName());
    }
}
