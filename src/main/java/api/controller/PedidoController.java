package api.controller;


import api.assembler.PedidoModelAssembler;
import api.dto.PedidoDTO;
import domain.model.Pedido;
import domain.repository.PedidoRepository;
import domain.service.EmissaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService emissaoPedido;
    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @GetMapping
    public List<PedidoDTO> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidoModelAssembler.toCollectionModel(pedidos);
    }

    @GetMapping("/{codigoPedido}")
    public PedidoDTO buscar(@PathVariable String codigoPedido) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

        return pedidoModelAssembler.toModel(pedido);
    }






}
