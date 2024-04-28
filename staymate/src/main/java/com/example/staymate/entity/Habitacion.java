package com.example.staymate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="HABITACION")
@Entity
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero", length = 255)
    private Integer numero;

    @Column(name = "categoria", length = 255)
    private String categoria;

    @Column(name = "estado", length = 255)
    private String estado;

    @Column(name = "ocupantes", length = 255)
    private Integer ocupantes;

    @Column(name = "banos", length = 255)
    private Integer banos;


}
