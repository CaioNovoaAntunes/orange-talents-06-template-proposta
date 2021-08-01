package com.br.proposta.repositorios;

import com.br.proposta.modelo.AvisoViagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AvisoViagemRepository extends JpaRepository<AvisoViagem, Long> {

    Optional<AvisoViagem> findByDataFinal(LocalDate dataFinal);


}
