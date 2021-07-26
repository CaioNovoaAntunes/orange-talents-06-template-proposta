package com.br.proposta.schdules;

import com.br.proposta.cartao.AssociaCartao;
import com.br.proposta.dto.CartaoResponse;
import com.br.proposta.modelo.Proposta;
import com.br.proposta.modelo.PropostaRepository;
import com.br.proposta.status.StatusProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@EnableAsync
@EnableScheduling
public class CartaoSchdule {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    AssociaCartao associaCartao;

    @Scheduled(fixedRate=60000)
    public void associaCartao() {

        List<Proposta> proposals = propostaRepository.
                findByStatusAndNumeroCartaoIsNull(StatusProposta.ELEGIVEL);
        proposals.forEach(p -> {
            try {
                CartaoResponse cartaoResponse = associaCartao.buscaCartao(p.getId().toString());
                p.setaCartao(cartaoResponse.getNumeroCartao());
                propostaRepository.save(p);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Não foi possível associar o cartão a proposta: " + e);
            }
        });

    }
}