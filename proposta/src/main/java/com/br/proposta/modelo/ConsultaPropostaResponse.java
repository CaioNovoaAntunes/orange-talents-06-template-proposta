package com.br.proposta.modelo;

import com.br.proposta.status.StatusProposta;

public class ConsultaPropostaResponse {


    private StatusProposta status;

    public ConsultaPropostaResponse(Proposta proposta) {

        this.status = proposta.getStatus();
    }



    public StatusProposta getStatus() {
        return status;
    }
}