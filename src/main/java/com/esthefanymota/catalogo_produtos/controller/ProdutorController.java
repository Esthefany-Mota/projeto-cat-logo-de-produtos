package com.esthefanymota.catalogo_produtos.controller;

import com.esthefanymota.catalogo_produtos.dto.ProdutoRequestDTO;
import com.esthefanymota.catalogo_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutorController {

    @Autowired
    private ProdutoService service;



}
