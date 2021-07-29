package com.br.proposta.repositorios;

import com.br.proposta.modelo.biometria.Biometria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria, Long> {
   Optional<Biometria> findByImpressaoDigital(String impressaoDigital);
}