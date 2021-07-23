package com.br.proposta.analise;

import com.br.proposta.modelo.NovaPropostaResponse;
import com.br.proposta.modelo.SolicitacaoRequest;
import com.br.proposta.status.StatusSolicitacao;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@FeignClient(name = "analisa",
        url = "http://localhost:9999/api/solicitacao")
public interface AnalisaCliente {

    @CircuitBreaker(name = "analisa", fallbackMethod = "analiseFallback")
    @PostMapping
    NovaPropostaResponse sendSolicitation(@RequestBody SolicitacaoRequest request);

    default NovaPropostaResponse analiseFallback(Exception ex) {
        if (ex.getClass() == FeignException.UnprocessableEntity.class) {
            return new NovaPropostaResponse(StatusSolicitacao.COM_RESTRICAO);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível processar a análise da proposta");
    }

}