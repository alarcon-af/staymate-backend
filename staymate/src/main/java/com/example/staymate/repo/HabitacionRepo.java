package com.example.staymate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staymate.entity.Habitacion;


public interface HabitacionRepo extends JpaRepository<Habitacion, Integer> {
}
