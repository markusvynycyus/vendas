package domain.service;

import domain.exception.CategoriaNaoEncontradoException;
import domain.model.Categoria;
import domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCategoriaService {

    private static final String MSG_EXAME_PRATICO_EM_USO
            = "Categoria  de código %d não pode ser removido,está em uso";

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Categoria buscarOuFalhar(Long categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNaoEncontradoException(categoriaId));
    }


}

