package br.com.bluepoints.dto;

import br.com.bluepoints.model.Reciclagem;

import java.time.LocalDate;

public record ReciclagemExibirDto(
        Long id,
        Long usuario,
        String local,
        LocalDate data,
        Double peso
) {

    public ReciclagemExibirDto(Reciclagem reciclagem){
        this(
                reciclagem.getId(),
                reciclagem.getUsuario(),
                reciclagem.getLocal(),
                reciclagem.getData(),
                reciclagem.getPeso()
        );
    }

}
