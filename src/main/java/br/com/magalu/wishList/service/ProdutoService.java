package br.com.magalu.wishList.service;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magalu.wishList.modelo.Cliente;
import br.com.magalu.wishList.modelo.Produto;
import br.com.magalu.wishList.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> mostrarTodos() {
		return this.produtoRepository.findAll();
	}
	
	public Produto buscarPorId(String id) {
		return this.produtoRepository.findProdutoById(id);
	}
	
	public Produto criarProduto(Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	public Produto deletarProduto(String id) {
		this.buscarPorId(id);
		this.produtoRepository.deleteById(id);;
		return null; 
	}

	public List<Produto> buscarPorIdProduto(List<Produto> produto) {
		return this.produtoRepository.findProdutoById(produto);
	}

	
}
