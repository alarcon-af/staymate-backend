package com.example.staymate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staymate.entity.Reserva;

public interface ReservaRepo extends JpaRepository<Reserva, Integer>{
}
