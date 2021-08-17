package br.com.priscilasanfer.dscatalog.controller;

import br.com.priscilasanfer.dscatalog.entities.Category;
import br.com.priscilasanfer.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        var  list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
