package com.produtos.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.produtos.project.model.Produto;
import com.produtos.project.model.ProdutoRepository;

@Controller // @RestController > é utilizado para RESTAPI (Simulador de Requisição)
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    // EXIBINDO OS PRODUTOS
    @GetMapping("/") // Substitui a página de "erro" para a página listar.html
    public String listarProdutos(Model model) {
        model.addAttribute("todosOsProdutos", repository.findAll()); //addAttribute("nome da lista", método de busca)
        return "listar";
    }

    // CADASTRANDO O PRODUTO
    // Get -> Precisa retornar o formulário de cadastro do produto (cadastrar.html)
    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto()); // addAttribute("nome do model", construtor do model)
        return "cadastrar"; // é o cadastrar.html
    }

    // Post -> Cadastrar um produto com seus atributos(nome e preco).Irá ocorrer quando eu clicar no botão do formulário da página cadastrar.html
    @PostMapping("/cadastro")
    public String cadastrarProduto(Produto produto) {
        repository.save(produto);
        return "redirect:/"; // Vai retornar para a página inicial(listar.html)
    }

   

}