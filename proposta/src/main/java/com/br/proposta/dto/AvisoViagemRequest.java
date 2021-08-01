package com.br.proposta.dto;

import com.br.proposta.modelo.AvisoViagem;
import com.br.proposta.validation.NotExists;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class AvisoViagemRequest {
    @NotEmpty
    private String viagemDestino;

    @Future
    private LocalDate dataFinal;

    public AvisoViagemRequest(String viagemDestino, LocalDate dataFinal) {
        this.viagemDestino = viagemDestino;
        this.dataFinal = dataFinal;
    }

    public String getViagemDestino() {
        return viagemDestino;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }


    public AvisoViagem conversor(String numeroCartao,String ipRequest,String userAgent){

        return new AvisoViagem(numeroCartao,this.viagemDestino,this.dataFinal,ipRequest,userAgent);
    }
}
