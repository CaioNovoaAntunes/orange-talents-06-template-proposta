package com.br.proposta.modelo;

import com.br.proposta.integrations.AnalisaCliente;
import com.br.proposta.status.StatusProposta;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @Positive
    @NotNull
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    private String numeroCartao;

    public Proposta(String documento, String nome, String endereco, String email, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    @Deprecated
    public Proposta() {
    }

    public Long getId() {
        return id;
    }

    public void setaStatus(AnalisaCliente analise) {
        SolicitacaoRequest solicitacaoRequest = new SolicitacaoRequest(this.documento, this.nome, this.id);
        NovaPropostaResponse response = analise.sendSolicitation(solicitacaoRequest);
        StatusProposta status = response.getResultadoSolicitacao().conversorStatus();
        this.status = status;

    }

    public void setaCartao(String cartao) {
        this.numeroCartao = cartao;
    }

    private String encrypt(String document) {
        return new BCryptPasswordEncoder().encode(document);
    }

    public String getNome() {
        return nome;
    }

    public StatusProposta getStatus() {
        return status;
    }

}
