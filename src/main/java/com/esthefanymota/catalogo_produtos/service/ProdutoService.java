package com.esthefanymota.catalogo_produtos.service;

import com.esthefanymota.catalogo_produtos.dto.ProdutoRequestDTO;
import com.esthefanymota.catalogo_produtos.entity.ProdutoEntity;
import com.esthefanymota.catalogo_produtos.exception.ProdutoNaoEncontradoException;
import com.esthefanymota.catalogo_produtos.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoEntity> listarProdutosAtivos() {
        return repository.findByAtivoTrue();
    }

    public ProdutoEntity findById(Long id) {
        Optional<ProdutoEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));
    }

    public  ProdutoEntity insert(ProdutoEntity obj){
        if(obj.getId() != null){
            throw new IllegalStateException("Produto já inserido");
        }
        return repository.save(obj);
    }

    public ProdutoEntity fromDTO(ProdutoRequestDTO objDTO){
        ProdutoEntity entity = new ProdutoEntity();
        entity.setNome(objDTO.getNome());
        entity.setDescricao(objDTO.getDescricao());
        entity.setPreco(objDTO.getPreco());
        entity.setAtivo(objDTO.getAtivo());
        entity.setImagemUrl(objDTO.getImagemUrl());

        return entity;
    }

    public void deactivate(Long id) {
        ProdutoEntity produtoEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        produtoEntity.setAtivo(false);
        repository.save(produtoEntity);
    }

    public ProdutoEntity update(ProdutoEntity obj) {
        ProdutoEntity newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(ProdutoEntity newObj, ProdutoEntity obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
        newObj.setPreco(obj.getPreco());
        newObj.setImagemUrl(obj.getImagemUrl());
    }
}
