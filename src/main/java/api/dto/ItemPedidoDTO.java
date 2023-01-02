package api.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoDTO {

    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private Integer quantidade;
    private String observacao;
    private PedidoDTO pedido;
    private ProdutoDTO produto;

}
