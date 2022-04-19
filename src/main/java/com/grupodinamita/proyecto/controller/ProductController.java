package com.grupodinamita.proyecto.controller;

import com.grupodinamita.proyecto.entity.Product;
import com.grupodinamita.proyecto.entity.User;
import com.grupodinamita.proyecto.service.ProductService;
import com.grupodinamita.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Product> oPro=productService.findById(id);
        if(oPro.isPresent()){
            return ResponseEntity.ok(oPro);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id){
        Optional<Product> oUser= productService.findById(id);
        if(oUser.isPresent()){
            oUser.get().setName(product.getName());
            oUser.get().setDescription(product.getDescription());
            oUser.get().setPrice(product.getPrice());
            oUser.get().setId_categoria(product.getId_categoria());
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(oUser.get()));
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> oUser = productService.findById(id);
        if(oUser.isPresent()){
            productService.deleteById(id);
            return ResponseEntity.ok(oUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Product> showall(){
        List<Product> userList= StreamSupport.stream(productService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return userList;

    }


}
