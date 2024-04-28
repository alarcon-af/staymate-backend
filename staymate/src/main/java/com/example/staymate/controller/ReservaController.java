package com.example.staymate.controller;

import com.example.staymate.entity.Reserva;
import com.example.staymate.service.ReservaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService service;

    @GetMapping("/lista-reservas")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas =service.findAll();
        if(!reservas.isEmpty()){
            return new ResponseEntity<>(reservas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> conseguirReserva(@PathVariable Integer id) {
        Optional<Reserva> reserva = service.findById(id);
        return reserva.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/agregar")
    public ResponseEntity<Optional<Reserva>> agregarReserva(@RequestBody Reserva pendiente){
        Optional<Reserva> reserva = service.save(pendiente);
        if(reserva.isPresent()){
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> eliminarReserva(@PathVariable Integer id){
        Optional<Reserva> reserva = service.findById(id);
        if(reserva.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Integer id, @RequestBody Reserva pendienteActualizado){
        Reserva reserva = service.updateReserva(id, pendienteActualizado);

        if(reserva != null){
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
