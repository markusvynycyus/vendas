package domain.service;


import domain.exception.CategoriaNaoEncontradaException;
import domain.exception.EntidadeEmUsoException;
import domain.exception.ProdutoNaoEncontradoException;
import domain.model.Produto;
import domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {

    private static final String MSG_PRODUTO_EM_USO
            = "Produto  de código %d não pode ser removido,está em uso";

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }


    public Produto buscarOuFalhar(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
    }


    @Transactional
    public void excluir(Long produtoId) {
        try {
            produtoRepository.deleteById(produtoId);
            produtoRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new CategoriaNaoEncontradaException(produtoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_PRODUTO_EM_USO, produtoId));
        }
    }
}
