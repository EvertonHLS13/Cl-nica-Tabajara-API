package br.alura.ClinicaTabajaraAPI.controller;


import br.alura.ClinicaTabajaraAPI.dto.DadosAutenticacao;
import br.alura.ClinicaTabajaraAPI.dto.DadosTokenJWT;
import br.alura.ClinicaTabajaraAPI.infra.security.TokenService;
import br.alura.ClinicaTabajaraAPI.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarlogin(@RequestBody @Valid DadosAutenticacao dtoAu){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dtoAu.login(), dtoAu.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return  ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


}
