package com.produtos.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.produtos.project.models.Produto;
import com.produtos.project.models.ProdutoRepository;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller// @RestController só é utilizado para RESTAPI (simulador de requisições HTTP  )
public class ProdutoController {

    @Autowired//   injeção de dependência, ou seja, o Spring vai criar uma instância do ProdutoRepository e injetar aqui
    private ProdutoRepository repository;
    //EXIBINDO PRODUTO
    @GetMapping("/")//Substitui a página de erro para a página listar.html.
    public String listarProdutos(Model model) {
        model.addAttribute("todososprodutos", repository.findAll());// addattribute ("nome da lista", metodo de busca no banco de dados) -> O nome da lista é o nome que eu vou usar no html para acessar os atributos do model, e o metodo de busca no banco de dados é o método findAll() do repository, que retorna uma lista com todos os produtos cadastrados no banco de dados.
        return "listar";
    }

    //CADASTRANDO PRODUTO
    //GET -> que precisa retornar o cadastro do produto(cadastrar html)
    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model){
            model.addAttribute("produto", new Produto()); //AddAttribute ("nome do model", construtor do model) -> O nome do model é o nome que eu vou usar no html para acessar os atributos do model, e o construtor do model é a classe que eu criei para representar o produto, ou seja, a classe Produto.)  
            return "cadastrar"; // É um arquivo cadastrar.html
    }

    //POST -> cadastrar um produto com seus atributos (nome, preco). Irá ocorrer quando eu clicar no botão de cadastrar, ou seja, o formulário irá enviar os dados para o servidor, e o servidor irá processar esses dados e salvar no banco de dados.
    @PostMapping("/cadastro")
    public String cadastraProduto(Produto produto) {
        repository.save(produto); // O método save é utilizado para salvar o produto no banco de dados, ele recebe como parâmetro o produto que eu quero salvar, ou seja, o produto que eu recebi do formulário.    
        return "/"; // Vai retornar para a página principal;(listar.html)
    }
        
}
