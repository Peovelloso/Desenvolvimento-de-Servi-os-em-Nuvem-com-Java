package br.edu.infnetTp1.AppTP1.controller;

import br.edu.infnetTp1.AppTP1.model.Produto;
import br.edu.infnetTp1.AppTP1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    private String nome;


    @RequestMapping(value = "/produto/all", method = RequestMethod.GET)
    public List<Produto> findAll(){
        produtoRepository.save("Castanha");
        return produtoRepository.findAll();

    }
    @RequestMapping(value = "/produto/save", method = RequestMethod.GET)
    public Produto save(@RequestParam("nome") String nome){
        return produtoRepository.save(nome);

    }

    @RequestMapping(value = "/produto/update", method = RequestMethod.GET)
    public Produto update(@RequestParam("id") Integer id, @RequestParam("nome") String nome){
        Produto produto = produtoRepository.update(id, nome);
        return produto;
    }
    @RequestMapping(value = "/produto/delete", method = RequestMethod.GET)
    public String deletar(@RequestParam("id") Integer id){
        produtoRepository.delete(id);
        return "Produto com o codigo de ID " + id + " não encontra-se em estoque.";

    }
}
