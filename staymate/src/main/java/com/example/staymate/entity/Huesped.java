package com.example.staymate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="HUESPED")
@Entity
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped", length = 255)
    private Integer id_huesped;

    @Column(name = "identificacion", length = 255)
    private Integer identificacion;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "apellido", length = 255)
    private String apellido;

    @Column(name = "telefono", length = 255)
    private String telefono;

    @Column(name = "correo", length = 255)
    private String correo;

    @JoinColumn(name = "reserva", referencedColumnName = "referencia")
    private Integer reserva;

}
