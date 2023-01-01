package api.controller;


import api.assembler.ProdutoInputDisassembler;
import api.assembler.ProdutoModelAssembler;
import api.assembler.VendedorModelAssembler;
import api.dto.CategoriaDTO;
import api.dto.VendedorDTO;
import api.dto.input.CategoriaInput;
import domain.model.Categoria;
import domain.model.Vendedor;
import domain.repository.ProdutoRepository;
import domain.repository.VendedorRepository;
import domain.service.CadastroProdutoService;
import domain.service.CadastroVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CadastroVendedorService cadastroVendedorService;

    @Autowired
    private VendedorModelAssembler vendedorModelAssembler;

    @Autowired
    private VendedorInputDisassembler vendedorInputDisassembler;


    @GetMapping
    public List<VendedorDTO> listar() {
        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedorModelAssembler.toCollectionModel(vendedores);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO adicionar(@RequestBody @Valid VendedorInput vendedorInput) {
        Categoria categoria = vendedorInputDisassembler.toDomainObject(vendedorInput);
        categoria = cadastroVendedorService.salvar(categoria);

        return vendedorModelAssembler.toModel(categoria);
    }



}
