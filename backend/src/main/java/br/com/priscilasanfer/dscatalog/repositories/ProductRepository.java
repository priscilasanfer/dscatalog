package br.com.priscilasanfer.dscatalog.repositories;

import br.com.priscilasanfer.dscatalog.entities.Category;
import br.com.priscilasanfer.dscatalog.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT obj from Product obj INNER JOIN obj.categories cats WHERE " +
            "(:category IS NULL OR :category IN cats)")
    Page<Product> find(Category category, Pageable pageable);
}
