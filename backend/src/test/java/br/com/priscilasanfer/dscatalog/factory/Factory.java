package br.com.priscilasanfer.dscatalog.factory;

import br.com.priscilasanfer.dscatalog.dto.ProductDTO;
import br.com.priscilasanfer.dscatalog.entities.Category;
import br.com.priscilasanfer.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {
    public static Product createProduct() {
        Product product = new Product(1L,
                " The Lord of the Rings",
                "Lorem ipsum dolor sit amet, id est laborum",
                90.5,
                "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
                Instant.parse("2020-07-13T20:50:07.12345Z"));

        product.getCategories().add(createCategory());
        return product;
    }

    public static ProductDTO createProductDto() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category createCategory() {
        return new Category(1L, "Books");
    }

}
