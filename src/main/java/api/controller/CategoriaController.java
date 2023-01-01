package api.controller;

import api.assembler.CategoriaInputDisassembler;
import api.assembler.CategoriaModelAssembler;
import api.dto.CategoriaDTO;
import api.dto.input.CategoriaInput;
import domain.model.Categoria;
import domain.repository.CategoriaRepository;
import domain.service.CadastroCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO adicionar(@RequestBody @Valid CategoriaInput categoriaInput) {
        Categoria categoria = categoriaInputDisassembler.toDomainObject(categoriaInput);
        categoria = cadastroCategoriaService.salvar(categoria);

        return categoriaModelAssembler.toModel(categoria);
    }

    @PutMapping("/{categoriaId }")
    public CategoriaDTO atualizar(@PathVariable Long categoriaId,
                                  @RequestBody @Valid CategoriaInput categoriaInput) {
        Categoria categoriaAtual = cadastroCategoriaService.buscarOuFalhar(categoriaId);
        categoriaInputDisassembler.copyToDomainObject(categoriaInput, categoriaAtual);
        categoriaAtual = cadastroCategoriaService.salvar(categoriaAtual);

        return categoriaModelAssembler.toModel(categoriaAtual);
    }

    @DeleteMapping("/{categoriaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long categoriaId) {
        cadastroCategoriaService.excluir(categoriaId);
    }






}
