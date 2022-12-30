package api.assembler;


import api.dto.CategoriaDTO;
import domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaDTO toModel(Categoria cozinha) {
        return modelMapper.map(cozinha, CategoriaDTO.class);
    }

    public List<CategoriaDTO> toCollectionModel(List<Categoria> categorias) {
        return categorias.stream()
                .map(categoria -> toModel(categoria))
                .collect(Collectors.toList());
    }
}
