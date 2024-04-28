package com.example.staymate.service;

import com.example.staymate.repo.ReservaRepo;
import com.example.staymate.entity.Reserva;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepo repo;

    public List<Reserva> findAll() { return repo.findAll(); }

    public Optional<Reserva> findById(Integer id){
        Optional<Reserva> reserva = repo.findById(id);
        return reserva;
    }

    public Optional<Reserva> save(Reserva reserva){
        repo.save(reserva);
        Optional<Reserva> pendiente = repo.findById(reserva.getReferencia());
        return pendiente;
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public Reserva updateReserva(Integer id, Reserva reserva){
        Reserva pendiente = repo.findById(id).orElse(null);

        if (pendiente != null && reserva != null){
            if(reserva.getHuesped() != null){
                pendiente.setHuesped(reserva.getHuesped());
            }
            if(reserva.getNombre_huesped() != null){
                pendiente.setNombre_huesped(reserva.getNombre_huesped());
            }
            if(reserva.getCategoria() != null){
                pendiente.setCategoria(reserva.getCategoria());
            }
            if(reserva.getNombre_cat() != null){
                pendiente.setNombre_cat(reserva.getNombre_cat());
            }
            if(reserva.getCheck_in() != null){
                pendiente.setCheck_in(reserva.getCheck_in());
            }
            if(reserva.getCheck_out() != null){
                pendiente.setCheck_out(reserva.getCheck_out());
            }
            if(reserva.getTag() != null){
                pendiente.setTag(reserva.getTag());
            }
            if(reserva.getValor() != null){
                pendiente.setValor(reserva.getValor());
            }
            if(reserva.getOcupantes() != null){
                pendiente.setOcupantes(reserva.getOcupantes());
            }
            repo.save(pendiente);
            return pendiente;
        }else{
            return null;
        }
    }
}
