package com.grupodinamita.proyecto.controller;

import com.grupodinamita.proyecto.entity.Detalle;
import com.grupodinamita.proyecto.entity.Encabezado;
import com.grupodinamita.proyecto.entity.User;
import com.grupodinamita.proyecto.service.DetalleService;
import com.grupodinamita.proyecto.service.EncabezadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/factura")
public class CreacionDeFacturaCompleta {
    Optional<Encabezado> op;


    @Autowired
    private DetalleService detalleService;

    @Autowired
    private EncabezadoService encabezadoService;

    @PostMapping("/detalle")
    public ResponseEntity<?> create(@RequestBody Detalle detalle){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalle));
    }

    @PostMapping("/encabezado")
    public ResponseEntity<?> create(@RequestBody Encabezado encabezado){
        return ResponseEntity.status(HttpStatus.CREATED).body(encabezadoService.save(encabezado));
    }

    @GetMapping("/encabezado/{id}")
    public ResponseEntity<?> findbyIdEncabezado(@PathVariable Long id){
        Optional<Encabezado> oUser=encabezadoService.findById(id);
        if(oUser.isPresent()){
            return ResponseEntity.ok(oUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> findbyIdDetalle(@PathVariable Long id){
        Optional<Detalle> oUser=detalleService.findById(id);
        if(oUser.isPresent()){
            return ResponseEntity.ok(oUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/encabezado/{id}")
    public ResponseEntity<?> update(@RequestBody Encabezado encabezado, @PathVariable Long id){
        Optional<Encabezado> oUser= encabezadoService.findById(id);
        if(oUser.isPresent()){
            //oUser.get().setName(user.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(encabezadoService.save(oUser.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/detalle/{id}")
    public ResponseEntity<?> update(@RequestBody Detalle detalle, @PathVariable Long id){
        Optional<Detalle> oUser= detalleService.findById(id);
        if(oUser.isPresent()){
            //oUser.get().setName(user.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(oUser.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/detalle/all")
    public List<Detalle> showalldetalle(){
        List<Detalle> userList= StreamSupport.stream(detalleService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return userList;

    }


    @GetMapping("/encabezado/all")
    public List<Encabezado> showallencabezado(){
        List<Encabezado> userList= StreamSupport.stream(encabezadoService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return userList;

    }

}
