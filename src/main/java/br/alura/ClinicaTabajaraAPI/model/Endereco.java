package br.alura.ClinicaTabajaraAPI.model;

import br.alura.ClinicaTabajaraAPI.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;


    public Endereco(DadosEndereco dtoE) {
      this.logradouro = dtoE.logradouro();
      this.bairro = dtoE.bairro();
      this.cep = dtoE.cep();
      this.numero = dtoE.numero();
      this.complemento = dtoE.complemento();
      this.cidade = dtoE.cidade();
      this.uf = dtoE.uf();
    }

    public void atualizarInformacoes(DadosEndereco dtoE) {
        if (dtoE.logradouro() != null){
            this.logradouro = dtoE.logradouro();
        }
        if (dtoE.bairro() != null){
            this.bairro = dtoE.bairro();
        }
        if (dtoE.cep() != null){
            this.cep = dtoE.cep();
        }
        if (dtoE.numero() != null){
            this.numero = dtoE.numero();
        }
        if (dtoE.complemento() != null){
            this.complemento = dtoE.complemento();
        }
        if (dtoE.cidade() != null){
            this.cidade = dtoE.cidade();
        }
        if (dtoE.uf() != null){
            this.uf = dtoE.uf();
        }

    }
}
