package br.com.magalu.wishList.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.magalu.wishList.modelo.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
	public Produto findProdutoById(String id);
	public List<Produto> findProdutoById(List<Produto> produto);
}
