package org.golden.clear.products.Domain.models;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Long id;



    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "La longitud del nombre debe estar entre 1 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser un valor positivo")
    private Double price;
}
