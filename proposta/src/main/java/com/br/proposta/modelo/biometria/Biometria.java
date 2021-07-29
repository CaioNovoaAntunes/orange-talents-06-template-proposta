package com.br.proposta.modelo.biometria;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", message = "Ocorreu um erro ao cadastrar a biometria!")
    private String impressaoDigital;


    private String numeroCartao;
    @CreationTimestamp
    private LocalDateTime dataRegistro;

    public Biometria(String impressaoDigital, String numeroCartao) {
        this.impressaoDigital = impressaoDigital;
        this.numeroCartao = numeroCartao;
    }

    @Deprecated
    public Biometria() {
    }

    public Biometria(String impressaoDigital) {
        this.impressaoDigital = impressaoDigital;
    }


    public Long getId() {
        return id;
    }
}
