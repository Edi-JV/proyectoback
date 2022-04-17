package com.grupodinamita.proyecto.controller;

import com.grupodinamita.proyecto.entity.Inventario;
import com.grupodinamita.proyecto.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/inventary")
public class InventarioController {

    @Autowired
    private InventarioService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inventario product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Inventario> oPro=productService.findById(id);
        if(oPro.isPresent()){
            return ResponseEntity.ok(oPro);
        }else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Inventario> oUser = productService.findById(id);
        if(oUser.isPresent()){
            productService.deleteById(id);
            return ResponseEntity.ok(oUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Inventario> showall(){
        List<Inventario> userList= StreamSupport.stream(productService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return userList;

    }

}
