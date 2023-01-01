package api.assembler;

import api.dto.input.VendedorInput;
import domain.model.Vendedor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class VendedorInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Vendedor toDomainObject(@Valid VendedorInput vendedorInput) {
        return modelMapper.map(vendedorInput, Vendedor.class);
    }

    public void copyToDomainObject(VendedorInput vendedorInput, Vendedor vendedor) {
        modelMapper.map(vendedorInput, vendedor);
    }
}
