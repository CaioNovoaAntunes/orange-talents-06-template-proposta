package com.br.proposta.repositorios;

import com.br.proposta.modelo.CarteiraSamsung;
import com.br.proposta.modelo.carteiras.CarteiraPaypal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraSamsungRepository extends JpaRepository<CarteiraSamsung,Long> {
    Optional<CarteiraSamsung> findByNumeroCartao(String id);
}