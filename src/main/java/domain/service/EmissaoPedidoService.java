package domain.service;

import domain.exception.PedidoNaoEncontradoException;
import domain.model.Pedido;
import domain.model.Produto;
import domain.model.Usuario;
import domain.model.Vendedor;
import domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CadastroVendedorService cadastroVendedorService;
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Transactional
    public Pedido emitir(Pedido pedido) {
        validarPedido(pedido);
        validarItens(pedido);

       pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    private void validarPedido(Pedido pedido) {
        Usuario cliente = cadastroUsuarioService.buscarOuFalhar(pedido.getCliente().getId());
        Vendedor vendedor = cadastroVendedorService.buscarOuFalhar(pedido.getVendedor().getId());


        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);

    }

    private void validarItens(Pedido pedido) {
        pedido.getItens().forEach(item -> {
            Produto produto = cadastroProdutoService.buscarOuFalhar(
                    pedido.getVendedor().getId());

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
        });
    }



    public Pedido buscarOuFalhar(String codigoPedido) {
        return pedidoRepository.findByCodigo(codigoPedido)
                .orElseThrow(() -> new PedidoNaoEncontradoException(codigoPedido));
    }


}
