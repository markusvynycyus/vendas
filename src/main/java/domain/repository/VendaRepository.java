package domain.repository;

import domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Pedido,Long> {

    Optional<Pedido> findByCodigo(String codigo);

}
