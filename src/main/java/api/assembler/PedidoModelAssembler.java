package api.assembler;

import api.dto.PedidoDTO;
import domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO toModel(Pedido pedido) {

        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> toModel(pedido))
                .collect(Collectors.toList());
    }





}
