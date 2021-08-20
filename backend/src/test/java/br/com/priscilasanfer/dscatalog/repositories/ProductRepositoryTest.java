package br.com.priscilasanfer.dscatalog.repositories;

import br.com.priscilasanfer.dscatalog.entities.Product;
import br.com.priscilasanfer.dscatalog.factory.ProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private long totalCount;


    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistingId = 100L;
        totalCount = 25L;
    }

    @Test
    public void deleteShouldDeleteWhenIdExists() {
        repository.deleteById(existingId);
        Optional<Product> result = repository.findById(existingId);

        assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExists() {
        assertThrows(EmptyResultDataAccessException.class,
                () -> repository.deleteById(nonExistingId));
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull(){
        Product product = ProductFactory.createProduct();
        product.setId(null);

        product = repository.save(product);

        assertNotNull(product.getId());
        assertEquals(totalCount + 1 , product.getId());
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalProductWhenIdExists(){
        Optional<Product> product = repository.findById(existingId);

        assertTrue(product.isPresent());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalProductWhenIdDoesNotExists(){
        Optional<Product> product = repository.findById(nonExistingId);

        assertTrue(product.isEmpty());
    }


    /*
    findById deveria
    retornar um Optional<Product> não vazio quando o id existir
    retornar um Optional<Product> vazio quando o id não existir

     */


}