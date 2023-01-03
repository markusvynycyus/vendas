package api.assembler;

import api.dto.input.UsuarioComSenhaInput;
import api.dto.input.UsuarioInput;
import domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UsuarioInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Usuario toDomainObject(@Valid UsuarioComSenhaInput usuarioInput) {
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
        modelMapper.map(usuarioInput, usuario);
    }
}
