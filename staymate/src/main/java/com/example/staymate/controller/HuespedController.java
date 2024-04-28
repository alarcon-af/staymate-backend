package com.example.staymate.controller;

import com.example.staymate.service.HuespedService;
import com.example.staymate.entity.Huesped;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/huesped")
public class HuespedController {

    @Autowired
    private HuespedService service;

    @GetMapping("/lista-huespedes")
    public ResponseEntity<List<Huesped>> getAllHuespedes() {
        List<Huesped> huespedes =service.findAll();
        if(!huespedes.isEmpty()){
            return new ResponseEntity<>(huespedes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huesped> conseguirHuesped(@PathVariable Integer id) {
        Optional<Huesped> cliente = service.findById(id);
        return cliente.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre")
    public ResponseEntity<Huesped> conseguirPorNombre(@RequestBody String nombre, @RequestBody String apellido){
        Optional<Huesped> cliente = service.findByNombre(nombre, apellido);
        return cliente.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Huesped>> agregarHuesped(@RequestBody Huesped cliente){
        Optional<Huesped> huesped = service.save(cliente);
        if(huesped.isPresent()){
            return new ResponseEntity<>(huesped, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarHuesped(@PathVariable Integer id){
        Optional<Huesped> huesped = service.findById(id);
        if(huesped.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Huesped> actualizarHuesped(@PathVariable Integer id, @RequestBody Huesped HuespedActualizado){
        Huesped cliente = service.updateHuesped(id, HuespedActualizado);

        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
