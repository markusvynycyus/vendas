package domain.exception;

public class VendedorNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public VendedorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public VendedorNaoEncontradoException(Long vendedorId) {
        this(String.format("Não existe um cadastro de vendedor com código %d", vendedorId));
    }
}
