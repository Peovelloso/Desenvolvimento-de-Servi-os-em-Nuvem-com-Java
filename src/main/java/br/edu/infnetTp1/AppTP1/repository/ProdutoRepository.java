package br.edu.infnetTp1.AppTP1.repository;

import br.edu.infnetTp1.AppTP1.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProdutoRepository<produtoList> {

    private static List<Produto> produtoList = new ArrayList<>();

    public Produto save(String nome){
        Integer id = generateId();
        while (findById(id) != null){
            id = generateId();
        }
        Produto produto = new Produto();
        produto.setId(id);
        produto.setName(nome);
        produtoList.add(produto);
        return produto;

    }

    private Integer generateId(){
        Random r = new Random();
        return r.nextInt(100);
    }

    public Produto findById(Integer id) {
        if (id == null) {
            return null;
        }
        for (Produto p : produtoList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Produto update(Integer id, String nome){
        Produto produto = findById(id);
        if(produto != null){
            produto.setName(nome);
        }
        return produto;
    }

    public List<Produto> findAll() {
        return produtoList;
    }

    public void delete(Integer id) {
        Produto produto = findById(id);
        if (produto != null){
            produtoList.remove(produto);
        }
    }


}
