package com.br.proposta.modelo;

import com.br.proposta.analise.AnalisaCliente;
import com.br.proposta.status.StatusProposta;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProposta status = StatusProposta.ELEGIVEL;
    private String numeroCartao;
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private BigDecimal salario;


    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }
    @Deprecated
    public Proposta() {
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setaStatus(AnalisaCliente analise){
        try {
            SolicitacaoRequest solicitacaoRequest = new SolicitacaoRequest(this.documento, this.nome, this.id);
            NovaPropostaResponse response = analise.sendSolicitation(solicitacaoRequest);
            StatusProposta status =response.getResultadoSolicitacao().conversorStatus();
            this.status = status;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setaCartao(String cartao) {
        this.numeroCartao = cartao;
    }

    public String getNome() {
        return this.nome;
    }

    public StatusProposta getStatus() {
        return status;
    }
}
