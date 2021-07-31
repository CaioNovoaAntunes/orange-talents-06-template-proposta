package com.br.proposta.modelo.biometria;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
