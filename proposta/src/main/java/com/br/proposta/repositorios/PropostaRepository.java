package com.br.proposta.repositorios;


import com.br.proposta.modelo.Proposta;
import com.br.proposta.status.StatusProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    List<Proposta> findByStatusAndNumeroCartaoIsNull(StatusProposta elegivel);
    Proposta findByDocumento(String documento);
}