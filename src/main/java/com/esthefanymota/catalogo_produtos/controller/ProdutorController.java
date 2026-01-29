package com.esthefanymota.catalogo_produtos.controller;

import com.esthefanymota.catalogo_produtos.entity.ProdutoEntity;
import com.esthefanymota.catalogo_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutorController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoEntity> insert(@RequestBody ProdutoEntity obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> findAll(){
        List<ProdutoEntity> list = service.listarProdutosAtivos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> findById(@PathVariable Long id){
        ProdutoEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @RequestBody ProdutoEntity obj){
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
