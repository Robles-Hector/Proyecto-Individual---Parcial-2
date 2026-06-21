package edu.espe.f1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class Team {
    @Id
    private String id;

    @NotBlank(message = "El nombre de la escudería es obligatorio")
    private String name;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String fullName;

    @NotBlank(message = "La sede es obligatoria")
    private String base;

    @Min(value = 1950, message = "Año de fundación inválido")
    private int founded;

    @Min(value = 0, message = "Los campeonatos no pueden ser negativos")
    private int championships;

    @NotBlank(message = "El color hexadecimal es obligatorio")
    private String color;

    private int wins;
}