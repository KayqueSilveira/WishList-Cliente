package br.com.magalu.wishList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magalu.wishList.modelo.Produto;
import br.com.magalu.wishList.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> mostrarTodos() {
		return this.produtoService.mostrarTodos();
	}
	
	@PostMapping("/criarProduto")
	public ResponseEntity criarProduto(@RequestBody Produto produto) {
		this.produtoService.criarProduto(produto);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity deletarProduto(@PathVariable String id) {
		this.produtoService.deletarProduto(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity mostrarTodos(@PathVariable String id) {
		Produto produto = this.produtoService.buscarPorId(id);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
}
