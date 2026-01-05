package br.alura.ClinicaTabajaraAPI.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedido(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco ) {
}
