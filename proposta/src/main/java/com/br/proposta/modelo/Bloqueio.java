package com.br.proposta.modelo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Bloqueio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String numeroCartao;

    @NotBlank
    private String ipSolicitante;

    @NotBlank
    private String userAgent;

    @CreationTimestamp
    LocalDateTime dataBloqueio;

    public Bloqueio(String numeroCartao, String ipSolicitante, String userAgent) {
        this.numeroCartao = numeroCartao;
        this.ipSolicitante = ipSolicitante;
        this.userAgent = userAgent;
    }

    @Deprecated
    public Bloqueio(){}

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getIpSolicitante() {
        return ipSolicitante;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public LocalDateTime getDataBloqueio() {
        return dataBloqueio;
    }
}