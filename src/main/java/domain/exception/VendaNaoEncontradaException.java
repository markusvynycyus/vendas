package domain.exception;

public class VendaNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public VendaNaoEncontradaException(String mensagem) {
            super(mensagem);
        }

    public VendaNaoEncontradaException(Long codigoVenda) {
            this(String.format("Não existe um cadastro de Venda com código %d", codigoVenda));
        }
}
