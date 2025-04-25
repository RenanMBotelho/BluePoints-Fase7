package br.com.bluepoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record ReciclagemCadastroDto(

        Long id,

        @NotNull(message = "O código do usuário é obrigatório!")
        Long usuario,

        @NotBlank(message = "O local da reciclagem é obrigatório!")
        String local,

        @NotNull(message = "Por favor, insira a data da reciclagem.")
        LocalDate data,

        @NotNull(message = "Digite o peso de material reciclado.")
        @Positive
        Double peso
) {
}
