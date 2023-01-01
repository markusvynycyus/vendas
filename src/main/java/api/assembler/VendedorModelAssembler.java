package api.assembler;

import api.dto.ProdutoDTO;
import api.dto.VendedorDTO;
import domain.model.Produto;
import domain.model.Vendedor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VendedorModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public VendedorDTO toModel(Vendedor vendedor) {

        return modelMapper.map(vendedor, VendedorDTO.class);
    }

    public List<VendedorDTO> toCollectionModel(List<Vendedor> vendedores) {
        return vendedores.stream()
                .map(vendedor -> toModel(vendedor))
                .collect(Collectors.toList());
    }
}
