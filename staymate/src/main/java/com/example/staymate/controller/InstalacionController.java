package com.example.staymate.controller;

import com.example.staymate.entity.Instalacion;
import com.example.staymate.service.InstalacionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instalacion")
public class InstalacionController {
    
    @Autowired
    private InstalacionService service;

    @GetMapping("/lista-instalaciones")
    public ResponseEntity<List<Instalacion>> getAllInstalaciones() {
        List<Instalacion> espacios =service.findAll();
        if(!espacios.isEmpty()){
            return new ResponseEntity<>(espacios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> conseguirInstalacion(@PathVariable Integer id) {
        Optional<Instalacion> espacio = service.findById(id);
        return espacio.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Instalacion>> agregarInstalacion(@RequestBody Instalacion instalacion){
        Optional<Instalacion> espacio = service.save(instalacion);
        if(espacio.isPresent()){
            return new ResponseEntity<>(espacio, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarInstalacion(@PathVariable Integer id){
        Optional<Instalacion> espacio = service.findById(id);
        if(espacio.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Instalacion> actualizarInstalacion(@PathVariable Integer id, @RequestBody Instalacion instalacionActualizado){
        Instalacion espacio = service.updateInstalacion(id, instalacionActualizado);

        if(espacio != null){
            return new ResponseEntity<>(espacio, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
