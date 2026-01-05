package br.alura.ClinicaTabajaraAPI.model;

import br.alura.ClinicaTabajaraAPI.Enum.Especialidade;
import br.alura.ClinicaTabajaraAPI.dto.DadosAtualizarMedido;
import br.alura.ClinicaTabajaraAPI.dto.DadosCadastroMedido;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedido dto) {
        this.ativo = true;
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.crm = dto.crm();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
    }

    public void atualizarinformacoes(@Valid DadosAtualizarMedido dtoA) {
        if (dtoA.nome() != null ){
            this.nome = dtoA.nome();
        }
        if (dtoA.telefone() != null){
            this.telefone = dtoA.telefone();
        }
        if (dtoA.endereco() != null){
            this.endereco.atualizarInformacoes(dtoA.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
