package api.dto.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
