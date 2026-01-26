package com.esthefanymota.catalogo_produtos.dto;

import com.esthefanymota.catalogo_produtos.entity.ProdutoEntity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private BigDecimal preco;
    private String imagemUrl;

    public ProdutoResponseDTO(){}

    public ProdutoResponseDTO(ProdutoEntity object){
        id = object.getId();
        nome = object.getNome();
        preco = object.getPreco();
        imagemUrl = object.getImagemUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

}
