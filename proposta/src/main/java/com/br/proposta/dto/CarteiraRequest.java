package com.br.proposta.dto;

import com.br.proposta.CarteiraDigital;
import com.br.proposta.modelo.carteiras.CarteiraPaypal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraRequest {
    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private CarteiraDigital carteira;

    public CarteiraRequest(String email, CarteiraDigital carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    @Deprecated
    public CarteiraRequest(){
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigital getCarteira() {
        return carteira;
    }

    public CarteiraPaypal conversor(String numeroCartao) {
        return new CarteiraPaypal(this.email,numeroCartao);
    }
}