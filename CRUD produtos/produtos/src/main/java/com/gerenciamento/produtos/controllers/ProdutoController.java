package com.gerenciamento.produtos.controllers;

import com.gerenciamento.produtos.entities.Produto;
import com.gerenciamento.produtos.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Criar um novo produto.")
    @PostMapping("/create-produto")
    public ResponseEntity<Produto> CreateProduto(@RequestBody Produto produto){
        return produtoService.createProduto(produto);
    }

    @GetMapping("/List-all-produtos")
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return produtoService.getAllProdutos();
    }

    @GetMapping("/List-produto/{id}")
    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id){
        return produtoService.getProdutoById(id);
    }

}
