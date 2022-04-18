package com.grupodinamita.proyecto.controller;
import com.grupodinamita.proyecto.entity.subclases.Category;
import com.grupodinamita.proyecto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category){

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Category> oCategory=categoryService.findById(id);
        if(oCategory.isPresent()){
            return ResponseEntity.ok(oCategory);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long id){
        Optional<Category> oCategory= categoryService.findById(id);
        if(oCategory.isPresent()){
            oCategory.get().setCategoryName(category.getCategoryName());
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(oCategory.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Category> oCategory = categoryService.findById(id);
        if(oCategory.isPresent()){
            categoryService.deleteById(id);
            return ResponseEntity.ok(oCategory);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Category> showall(){
        List<Category> categoryList= StreamSupport.stream(categoryService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return categoryList;

    }
    
}
