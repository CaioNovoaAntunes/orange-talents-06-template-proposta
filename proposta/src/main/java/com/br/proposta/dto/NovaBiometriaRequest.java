package com.br.proposta.dto;

import com.br.proposta.modelo.biometria.Biometria;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;


public class NovaBiometriaRequest {
    @Valid
    @NotBlank
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", message = "Ocorreu um erro ao cadastrar a biometria!")


    private String impressaoDigital;
    @JsonCreator(mode = Mode.PROPERTIES)
    public NovaBiometriaRequest(String impressaoDigital) {
        this.impressaoDigital = impressaoDigital;
    }

    public String getImpressaoDigital() {
        return impressaoDigital;
    }


    public Biometria toModelo(){
        return new Biometria(impressaoDigital);
    }

}