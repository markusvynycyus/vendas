package domain.service;

import domain.exception.CategoriaNaoEncontradaException;
import domain.exception.EntidadeEmUsoException;
import domain.model.Categoria;
import domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCategoriaService {

    private static final String MSG_CATEGORIA_EM_USO
            = "Categoria  de código %d não pode ser removido,está em uso";

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Categoria buscarOuFalhar(Long categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(categoriaId));
    }


    @Transactional
    public void excluir(Long categoriaId) {
        try {
            categoriaRepository.deleteById(categoriaId);
            categoriaRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new CategoriaNaoEncontradaException(categoriaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CATEGORIA_EM_USO, categoriaId));
        }
    }


}

