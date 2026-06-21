package edu.espe.f1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drivers")
@Data
@NoArgsConstructor
public class Driver {
    @Id
    private String id;

    @NotBlank(message = "El nombre del piloto es obligatorio")
    private String name;

    @NotBlank(message = "El slug es obligatorio")
    private String slug;

    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nationality;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    private String born;

    @Min(value = 1, message = "Número de piloto inválido")
    private int number;

    private int championships;
    private int wins;
    private int podiums;
    private int poles;
    private double points;
    
    @Column(columnDefinition = "TEXT")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team currentTeam;
}