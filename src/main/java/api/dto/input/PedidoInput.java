package api.dto.input;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class PedidoInput {

    @Valid
    @NotNull
    private VendedorIdInput vendendor;

    @Valid
    @NotNull
    private UsuarioInput cliente;

    @Valid
    //@Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;


}
