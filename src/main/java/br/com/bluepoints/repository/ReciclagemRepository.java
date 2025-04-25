package br.com.bluepoints.repository;

import br.com.bluepoints.model.Reciclagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReciclagemRepository extends JpaRepository<Reciclagem, Long> {

    public Optional<Reciclagem> findById(Long id);

    public Optional<Reciclagem> findByUsuario(Long usuario);

}
