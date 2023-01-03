package api.controller;


import api.assembler.VendedorInputDisassembler;
import api.assembler.VendedorModelAssembler;
import api.dto.VendedorDTO;
import api.dto.input.VendedorInput;
import domain.model.Vendedor;
import domain.repository.VendedorRepository;
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


    @PutMapping("/{vendedorId }")
    public VendedorDTO atualizar(@PathVariable Long vendedorId,
                                @RequestBody @Valid VendedorInput vendedorInput) {
        Vendedor vendedorAtual = cadastroVendedorService.buscarOuFalhar(vendedorId);
        vendedorInputDisassembler.copyToDomainObject(vendedorInput, vendedorAtual);
        vendedorAtual = cadastroVendedorService.salvar(vendedorAtual);

        return vendedorModelAssembler.toModel(vendedorAtual);
    }

    @DeleteMapping("/{vendedorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long vendedorId) {
        cadastroVendedorService.excluir(vendedorId);
    }

}
