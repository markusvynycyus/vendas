package domain.exception;

public class CategoriaNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CategoriaNaoEncontradoException(Long cidadeId) {
        this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
    }
}
