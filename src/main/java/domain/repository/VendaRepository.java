package domain.repository;

import domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {

    Optional<Venda> findByCodigo(String codigo);

}
