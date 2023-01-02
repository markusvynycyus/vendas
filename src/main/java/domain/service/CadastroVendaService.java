package domain.service;

import domain.exception.VendaNaoEncontradaException;
import domain.model.Venda;
import domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda buscarOuFalhar(String codigoVenda) {
        return vendaRepository.findByCodigo(codigoVenda)
                .orElseThrow(() -> new VendaNaoEncontradaException(codigoVenda));
    }

}
