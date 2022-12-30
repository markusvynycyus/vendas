package api.assembler;

import api.dto.input.CategoriaInput;
import domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Categoria toDomainObject(CategoriaInput categoriaInput) {
        return modelMapper.map(categoriaInput, Categoria.class);
    }

    public void copyToDomainObject(CategoriaInput categoriaInput, Categoria categoria) {
        modelMapper.map(categoriaInput, categoria);
    }
}
