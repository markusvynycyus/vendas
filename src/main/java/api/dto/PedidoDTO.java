package api.dto;

import api.dto.input.ItemPedidoInput;
import api.dto.input.UsuarioInput;
import api.dto.input.VendedorIdInput;
import com.sun.istack.NotNull;
import domain.model.ItemPedido;
import domain.model.Usuario;
import domain.model.Vendedor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class PedidoDTO {

    private String codigo;

    private BigDecimal subtotal;
    private BigDecimal valorTotal;
    private OffsetDateTime dataPedido;

    private VendedorDTO vendedor;

    private UsuarioDTO cliente;

    private List<ItemPedidoDTO> itens;



}
