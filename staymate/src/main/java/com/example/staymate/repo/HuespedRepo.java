package com.example.staymate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staymate.entity.Huesped;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HuespedRepo extends JpaRepository<Huesped, Integer> {

    @Query("SELECT c FROM Huesped c WHERE c.nombre = :nombre AND c.apellido = :apellido")
    Optional<Huesped> findByNombre(String nombre, String apellido);
}
