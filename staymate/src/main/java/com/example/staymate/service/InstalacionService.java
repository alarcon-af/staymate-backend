package com.example.staymate.service;

import com.example.staymate.entity.Instalacion;
import com.example.staymate.repo.InstalacionRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class InstalacionService {

    @Autowired
    private InstalacionRepo repo;

    public List<Instalacion> findAll() { return repo.findAll(); }

    public Optional<Instalacion> findById(Integer id){
        Optional<Instalacion> instalacion = repo.findById(id);
        return instalacion;
    }

    public Optional<Instalacion> save(Instalacion instalacion){
        repo.save(instalacion);
        Optional<Instalacion> espacio = repo.findById(instalacion.getId_insta());
        return espacio;
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public Instalacion updateInstalacion(Integer id, Instalacion instalacion){
        Instalacion espacio = repo.findById(id).orElse(null);

        if (espacio != null && instalacion != null){
            if(instalacion.getNombre() != null){
                espacio.setNombre(instalacion.getNombre());
            }
            if(instalacion.getActividad() != null){
                espacio.setActividad(instalacion.getActividad());
            }
            if(instalacion.getEstado() != null){
                espacio.setEstado(instalacion.getEstado());
            }
            if(instalacion.getUbicacion() != null){
                espacio.setUbicacion(instalacion.getUbicacion());
            }
            if(instalacion.getHorario_inicio() != null){
                espacio.setHorario_inicio(instalacion.getHorario_inicio());
            }
            if(instalacion.getHorario_fin() != null){
                espacio.setHorario_fin(instalacion.getHorario_fin());
            }
            repo.save(espacio);
            return espacio;
        }else{
            return null;
        }
    }
}
