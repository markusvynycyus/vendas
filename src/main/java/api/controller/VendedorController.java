package api.controller;


import api.assembler.ProdutoInputDisassembler;
import api.assembler.ProdutoModelAssembler;
import api.assembler.VendedorInputDisassembler;
import api.assembler.VendedorModelAssembler;
import api.dto.CategoriaDTO;
import api.dto.ProdutoDTO;
import api.dto.VendedorDTO;
import api.dto.input.CategoriaInput;
import api.dto.input.ProdutoInput;
import api.dto.input.VendedorInput;
import domain.model.Categoria;
import domain.model.Produto;
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
    public VendedorDTO adicionar(@RequestBody @Valid VendedorInput vendedorInput) {
        Vendedor vendedor = vendedorInputDisassembler.toDomainObject(vendedorInput);
        vendedor = cadastroVendedorService.salvar(vendedor);

        return vendedorModelAssembler.toModel(vendedor);
    }




}
