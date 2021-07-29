package com.br.proposta.integracoes;

import com.br.proposta.modelo.NovaPropostaResponse;
import com.br.proposta.dto.SolicitacaoRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AnalisaClienteService implements AnalisaCliente {
    @Override
    public NovaPropostaResponse sendSolicitation(@RequestBody SolicitacaoRequest request) {
        return null;
    }

    @Override
    public NovaPropostaResponse analiseFallback(Exception ex) {
        return AnalisaCliente.super.analiseFallback(ex);
    }
}
