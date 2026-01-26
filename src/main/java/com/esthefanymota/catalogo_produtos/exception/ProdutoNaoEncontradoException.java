package com.esthefanymota.catalogo_produtos.exception;

import java.io.Serial;

public class ProdutoNaoEncontradoException  extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String msg) {
        super(msg);
    }
}
