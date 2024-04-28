package com.example.staymate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="RESERVA")
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referencia", length = 255)
    private Integer referencia;

    @JoinColumn(name = "huesped", referencedColumnName = "id_huesped")
    private Integer huesped;

    @Column(name = "nombre_huesped", length = 255)
    private String nombre_huesped;

    @Column(name = "categoria", length = 255)
    private String categoria;

    @Column(name="nombre_cat", length = 255)
    private Integer nombre_cat;

    @Column(name = "check_in", length = 255)
    private Date check_in;

    @Column(name = "check_out", length = 255)
    private Date check_out;

    @Column(name = "tag", length = 255)
    private String tag;

    @Column(name = "valor", length = 255)
    private Integer valor;

    @Column(name = "ocupantes", length = 255)
    private Integer ocupantes;
}
