package api.controller;


import api.assembler.PedidoModelAssembler;
import api.dto.PedidoDTO;
import domain.model.Pedido;
import domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @GetMapping
    public List<PedidoDTO> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidoModelAssembler.toCollectionModel(pedidos);
    }







}
