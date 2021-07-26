package com.br.proposta.modelo;


import com.br.proposta.status.StatusProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    List<Proposta> findByStatusAndNumeroCartaoIsNull(StatusProposta elegivel);
}