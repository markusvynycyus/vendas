package api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


@Setter
@Getter
public class PedidoDTO {

    private String codigo;

    private BigDecimal subtotal;

    private BigDecimal valorTotal;

    @CreationTimestamp
    private OffsetDateTime dataPedido;

    private VendedorDTO vendedorDTO;
    private UsuarioDTO cliente;

    private List<ItemPedidoDTO> itens;
}
