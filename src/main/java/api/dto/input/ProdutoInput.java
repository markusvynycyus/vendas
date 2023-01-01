package api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Getter
@Setter
public class ProdutoInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private BigDecimal preco;

    @NotBlank
    private Boolean ativo;
}
