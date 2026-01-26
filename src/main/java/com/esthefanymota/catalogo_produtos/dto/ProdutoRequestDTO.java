package com.esthefanymota.catalogo_produtos.dto;

import com.esthefanymota.catalogo_produtos.entity.ProdutoEntity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo = true;
    private String imagemUrl;

    public ProdutoRequestDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
