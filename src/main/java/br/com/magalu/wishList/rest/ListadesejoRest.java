package br.com.magalu.wishList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magalu.wishList.modelo.Favorito;
import br.com.magalu.wishList.service.ListadesejoService;

@RestController
@RequestMapping("/favoritos")
public class ListadesejoRest {

	@Autowired
	private ListadesejoService listaService;
	
	@GetMapping("/todos")
	public List<Favorito> mostrarTodos(){
		return (List<Favorito>) this.listaService.mostrarTodos();
	}
	
	@PostMapping()
	public Favorito criarFavorito(@RequestBody Favorito lista) throws Exception {
		return this.listaService.criarFavorito(lista);
		
	}
	
	@GetMapping("/idFavorito/{id}")
	public ResponseEntity mostrarTodos(@PathVariable String id){
		return new ResponseEntity<>(this.listaService.mostrasFavorito(id), HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity mostraFavorito(@PathVariable String id){
		return new ResponseEntity<>(this.listaService.mostrasFavorito(id), HttpStatus.OK);
	}
	
}
