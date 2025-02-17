package com.br.proposta.modelo;


import com.br.proposta.customvalidation.CPF_CNPJ;
import com.br.proposta.validation.NotExists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaRequest {
    @CPF_CNPJ
    @NotExists(domainClass = Proposta.class,fieldName = "documento",message = "Documento informado já existe proposta ativa")
    @NotBlank
    private String documento;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;

    public NovaPropostaRequest(String documento, String email, String nome, String endereco,
                               BigDecimal salario) {

        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }



    public Proposta conversor(){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return new Proposta(encoder.encode(this.documento),this.nome,this.endereco,this.email,this.salario);
    }

    public String getDocumento() {
        return documento;
    }
}