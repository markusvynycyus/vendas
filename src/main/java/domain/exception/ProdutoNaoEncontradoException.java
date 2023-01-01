package domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException  {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
            super(mensagem);
        }

    public ProdutoNaoEncontradoException(Long cidadeId) {
            this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
        }
}