package domain.service;

import domain.exception.CategoriaNaoEncontradaException;
import domain.model.Categoria;
import domain.model.Vendedor;
import domain.repository.CategoriaRepository;
import domain.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroVendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Transactional
    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }


    public Vendedor buscarOuFalhar(Long vendendorId) {
        return vendedorRepository.findById(vendendorId)
                .orElseThrow(() -> new VendedorNaoEncontradoException(vendendorId));
    }

}
