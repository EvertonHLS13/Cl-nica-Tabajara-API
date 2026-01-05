package br.alura.ClinicaTabajaraAPI.dto;

import br.alura.ClinicaTabajaraAPI.Enum.Especialidade;
import br.alura.ClinicaTabajaraAPI.model.Endereco;
import br.alura.ClinicaTabajaraAPI.model.Medico;

public record DadosDetalhamentoMedico(Long id,
                                      String nome,
                                      String email,
                                      String crm,
                                      String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }

}
