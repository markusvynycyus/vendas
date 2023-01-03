package domain.service;

import domain.exception.EntidadeEmUsoException;
import domain.exception.VendedorNaoEncontradoException;
import domain.model.Vendedor;
import domain.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroVendedorService {

    private static final String MSG_VENDEDOR_EM_USO
            = "Vendedor  de código %d não pode ser removido,está em uso";


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

    @Transactional
    public void excluir(Long vendedorId) {
        try {
            vendedorRepository.deleteById(vendedorId);
            vendedorRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new VendedorNaoEncontradoException(vendedorId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_VENDEDOR_EM_USO, vendedorId));
        }
    }


}
