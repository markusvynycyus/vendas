package domain.exception;

import java.io.Serial;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CategoriaNaoEncontradaException(Long categoriaId) {
        this(String.format("Não existe um cadastro de categoria com código %d", categoriaId));
    }
}
