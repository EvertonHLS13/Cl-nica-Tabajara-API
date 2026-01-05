package br.alura.ClinicaTabajaraAPI.dto;

import br.alura.ClinicaTabajaraAPI.Enum.Especialidade;
import br.alura.ClinicaTabajaraAPI.model.Medico;

public record DadosListagemMedico(Long id,
                                  String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
