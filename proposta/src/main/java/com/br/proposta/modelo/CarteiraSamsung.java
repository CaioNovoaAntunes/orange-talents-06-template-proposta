package com.br.proposta.modelo;

import com.br.proposta.CarteiraDigital;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CarteiraSamsung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(unique = true)
    private String numeroCartao;


    private CarteiraDigital tipoCarteira = CarteiraDigital.SAMSUNGPAY;


    public CarteiraSamsung(String email,String numeroCartao) {
        this.email = email;
        this.numeroCartao = numeroCartao;
    }

    @Deprecated
    public CarteiraSamsung(){
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public CarteiraDigital getTipoCarteira() {
        return tipoCarteira;
    }
}