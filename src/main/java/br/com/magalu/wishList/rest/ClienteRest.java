package br.com.magalu.wishList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magalu.wishList.modelo.Cliente;
import br.com.magalu.wishList.modelo.Produto;
import br.com.magalu.wishList.service.ClienteService;
import br.com.magalu.wishList.service.ProdutoService;

@RestController
@RequestMapping("cliente")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity criarCliente(@RequestBody Cliente cliente) {
		this.clienteService.criarCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("")
	public List<Cliente> mostrarClientes(){
		return this.clienteService.mostrarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity mostrarCliente(@PathVariable String id) {
		
		Cliente base = this.clienteService.mostrarCliente(id); 
		if(base == null) {
			return new ResponseEntity<>(base, HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(base, HttpStatus.OK);
	}
	
	@GetMapping("/{idCliente}/{idProduto}")
	public ResponseEntity mostrarClienteProduto(@PathVariable String idCliente, @PathVariable String idProduto) {
		return new ResponseEntity<>(this.clienteService.mostrarFavoritoCliente(idCliente, idProduto), HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping("/remover/{idCliente}/{idProduto}")
	public ResponseEntity removerClienteProduto(@PathVariable String idCliente, @PathVariable String idProduto) throws Exception {
		Cliente base = this.clienteService.deletarFavorito(idCliente, idProduto);
		return new ResponseEntity<>(base, HttpStatus.OK);

	}
	
	
}
