package com.example.staymate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="INSTALACION")
@Entity
public class Instalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insta", length = 255)
    private Integer id_insta;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "actividad", length = 255)
    private String actividad;

    @Column(name = "estado", length = 255)
    private String estado;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

    @Column(name = "horario_inicio", length = 255)
    private Time horario_inicio;

    @Column(name = "horario_fin", length = 255)
    private Time horario_fin;
}
