package com.example.staymate.controller;

import com.example.staymate.service.HabitacionService;
import com.example.staymate.entity.Habitacion;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionService service;

    @GetMapping("/lista-habitaciones")
    public ResponseEntity<List<Habitacion>> getAllHabitaciones() {
        List<Habitacion> cuartos =service.findAll();
        if(!cuartos.isEmpty()){
            return new ResponseEntity<>(cuartos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> conseguirHabitacion(@PathVariable Integer id) {
        Optional<Habitacion> cuarto = service.findById(id);
        return cuarto.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Habitacion>> agregarHabitacion(@RequestBody Habitacion cuarto){
        Optional<Habitacion> habitacion = service.save(cuarto);
        if(habitacion.isPresent()){
            return new ResponseEntity<>(habitacion, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarHabitacion(@PathVariable Integer id){
        Optional<Habitacion> cuarto = service.findById(id);
        if(cuarto.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Integer id, @RequestBody Habitacion cuartoActualizado){
        Habitacion cuarto = service.updateHabitacion(id, cuartoActualizado);

        if(cuarto != null){
            return new ResponseEntity<>(cuarto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
