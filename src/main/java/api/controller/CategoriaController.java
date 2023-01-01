package api.controller;

import api.assembler.CategoriaInputDisassembler;
import api.assembler.CategoriaModelAssembler;
import api.dto.CategoriaDTO;
import domain.model.Categoria;
import domain.repository.CategoriaRepository;
import domain.service.CadastroCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository ;

    @Autowired
    private CadastroCategoriaService cadastroCategoriaService;

    @Autowired
    private CategoriaModelAssembler categoriaModelAssembler;

    @Autowired
    private CategoriaInputDisassembler categoriaInputDisassembler;

    @GetMapping
    public List<CategoriaDTO> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();

        return categoriaModelAssembler.toCollectionModel(categorias);
    }





}
