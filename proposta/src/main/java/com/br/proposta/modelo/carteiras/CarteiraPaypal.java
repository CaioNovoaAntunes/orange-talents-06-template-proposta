package com.br.proposta.modelo.carteiras;

import com.br.proposta.CarteiraDigital;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CarteiraPaypal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @Column(unique = true)
    private String numeroCartao;

    private CarteiraDigital carteiraDigital = CarteiraDigital.PAYPAL;

    public CarteiraPaypal(String email,String numeroCartao) {
        this.email = email;
        this.numeroCartao = numeroCartao;
    }

    @Deprecated
    public CarteiraPaypal(){
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
        return carteiraDigital;
    }
}