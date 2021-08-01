package com.br.proposta.modelo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AvisoViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numeroCartao;
    @Column(nullable = false)
    private String viagemDestino;
    @Future
    private LocalDate dataFinal;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String ipRequest;

    @Column(nullable = false)
    private String userAgent;


    public AvisoViagem(String numeroCartao, String viagemDestino, LocalDate dataFinal, String ipRequest, String userAgent) {
        this.numeroCartao = numeroCartao;
        this.viagemDestino = viagemDestino;
        this.dataFinal = dataFinal;
        this.createdAt = createdAt;
        this.ipRequest = ipRequest;
        this.userAgent = userAgent;
    }

    @Deprecated
    public AvisoViagem() {
    }



    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getViagemDestino() {
        return viagemDestino;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getIpRequest() {
        return ipRequest;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
