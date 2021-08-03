package com.br.proposta.repositorios;

import com.br.proposta.modelo.carteiras.CarteiraPaypal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraPaypalRepository extends JpaRepository<CarteiraPaypal, Long> {
    Optional<CarteiraPaypal> findByNumeroCartao(String id);
}
