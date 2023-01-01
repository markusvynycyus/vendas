package api.controller;


import api.assembler.CategoriaInputDisassembler;
import api.assembler.CategoriaModelAssembler;
import api.assembler.ProdutoInputDisassembler;
import api.assembler.ProdutoModelAssembler;
import api.dto.CategoriaDTO;
import api.dto.ProdutoDTO;
import api.dto.input.CategoriaInput;
import api.dto.input.ProdutoInput;
import domain.model.Categoria;
import domain.model.Produto;
import domain.repository.CategoriaRepository;
import domain.repository.ProdutoRepository;
import domain.service.CadastroCategoriaService;
import domain.service.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository ;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;


    @GetMapping
    public List<ProdutoDTO> listar() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtoModelAssembler.toCollectionModel(produtos);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO adicionar(@RequestBody @Valid ProdutoInput produtoInput) {
        Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
        produto = cadastroProdutoService.salvar(produto);

        return produtoModelAssembler.toModel(produto);
    }

    @PutMapping("/{produtoId }")
    public ProdutoDTO atualizar(@PathVariable Long produtoId,
                                  @RequestBody @Valid ProdutoInput produtoInput) {
        Produto produtoAtual = cadastroProdutoService.buscarOuFalhar(produtoId);
        produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);
        produtoAtual = cadastroProdutoService.salvar(produtoAtual);

        return produtoModelAssembler.toModel(produtoAtual);
    }

    @DeleteMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long categoriaId) {
        cadastroProdutoService.excluir(produtoId);
    }



}
