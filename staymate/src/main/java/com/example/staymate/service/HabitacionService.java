package com.example.staymate.service;

import com.example.staymate.entity.Habitacion;
import com.example.staymate.repo.HabitacionRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepo habitacionRepo;

    public List<Habitacion> findAll() { return habitacionRepo.findAll(); }

    public Optional<Habitacion> findById(Integer id){
    Optional<Habitacion> cuarto = findById(id);
    return cuarto;
    }

    public Optional<Habitacion> save(Habitacion cuarto){
        habitacionRepo.save(cuarto);
        Optional<Habitacion> cuartoGuardado = habitacionRepo.findById(cuarto.getNumero());
        return cuartoGuardado;
    }

    public void delete(Integer id){
        habitacionRepo.deleteById(id);
    }

    public Habitacion updateHabitacion(Integer id, Habitacion habi){
        Habitacion cuarto = habitacionRepo.findById(id).orElse(null);

        if (cuarto != null && habi != null){
            if(habi.getCategoria() != null){
                cuarto.setCategoria(habi.getCategoria());
            }
            if(habi.getEstado() != null){
                cuarto.setEstado(habi.getEstado());
            }
            if(habi.getOcupantes() != null){
                cuarto.setOcupantes(habi.getOcupantes());
            }
            if(habi.getBanos() != null){
                cuarto.setBanos(habi.getBanos());
            }

            habitacionRepo.save(cuarto);
            return cuarto;
        }else{
            return null;
        }
    }
}
