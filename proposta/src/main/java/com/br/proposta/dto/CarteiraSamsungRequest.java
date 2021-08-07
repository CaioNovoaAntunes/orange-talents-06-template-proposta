package com.br.proposta.dto;

import com.br.proposta.CarteiraDigital;
import com.br.proposta.modelo.CarteiraSamsung;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraSamsungRequest {

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private CarteiraDigital carteira;

    public CarteiraSamsungRequest(String email, CarteiraDigital carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    @Deprecated
    public CarteiraSamsungRequest(){
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigital getCarteira() {
        return carteira;
    }

    public CarteiraSamsung conversor(String numeroCartao) {
        return new CarteiraSamsung(this.email,numeroCartao);
    }
}