package com.esthefanymota.catalogo_produtos.repository;

import com.esthefanymota.catalogo_produtos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Long>{

    List<ProdutoEntity> findByAtivoTrue();
}
