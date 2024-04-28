package com.example.staymate.service;

import com.example.staymate.entity.Huesped;
import com.example.staymate.repo.HuespedRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepo repo;

    public List<Huesped> findAll() { return repo.findAll(); }

    public Optional<Huesped> findById(Integer id){
        Optional<Huesped> huesped = repo.findById(id);
        return huesped;
    }

    public Optional<Huesped> findByNombre(String nombre, String apellido){
        Optional<Huesped> huesped = repo.findByNombre(nombre, apellido);
        return huesped;
    }

    public Optional<Huesped> save(Huesped huesped){
        repo.save(huesped);
        Optional<Huesped> cliente = repo.findById(huesped.getId_huesped());
        return cliente;
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public Huesped updateHuesped(Integer id, Huesped huesped){
        Huesped cliente = repo.findById(id).orElse(null);

        if (cliente != null && huesped != null){
            if(huesped.getIdentificacion() != null){
                cliente.setIdentificacion(huesped.getIdentificacion());
            }
            if(huesped.getNombre() != null){
                cliente.setNombre(huesped.getNombre());
            }
            if(huesped.getApellido() != null){
                cliente.setApellido(huesped.getApellido());
            }
            if(huesped.getTelefono() != null){
                cliente.setTelefono(huesped.getTelefono());
            }
            if(huesped.getCorreo() != null){
                cliente.setCorreo(huesped.getCorreo());
            }
            if(huesped.getReserva() != null){
                cliente.setReserva(huesped.getReserva());
            }

            repo.save(cliente);
            return cliente;
        }else{
            return null;
        }
    }
}
