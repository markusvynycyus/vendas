package domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Pedido {

        @EqualsAndHashCode.Include
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String codigo;

        private BigDecimal subtotal;
        private BigDecimal valorTotal;

        @CreationTimestamp
        private OffsetDateTime dataVenda;


        @ManyToOne
        @JoinColumn(nullable = false)
        private Vendedor vendedor;


        @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
        private List<ItemPedido> itens = new ArrayList<>();

        public void calcularValorTotal() {
                getItens().forEach(ItemPedido::calcularPrecoTotal);

                this.subtotal = getItens().stream()
                        .map(item -> item.getPrecoTotal())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                this.valorTotal = this.subtotal;
        }
}
