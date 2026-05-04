package com.produtos.project.models;
import org.springframework.data.jpa.repository.JpaRepository;   
  public interface ProdutoRepository extends JpaRepository<Produto, Long> {
      
  }  

