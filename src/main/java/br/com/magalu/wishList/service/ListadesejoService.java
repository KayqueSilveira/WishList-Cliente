package br.com.magalu.wishList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magalu.wishList.modelo.Cliente;
import br.com.magalu.wishList.modelo.Favorito;
import br.com.magalu.wishList.modelo.Produto;
import br.com.magalu.wishList.repository.WishlistRepository;

@Service
public class ListadesejoService {
	
	@Autowired
	private WishlistRepository listaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public List<Favorito> mostrarTodos(){
		return this.listaRepository.findAll();
	}
	
	public Favorito criarFavorito(Favorito favorito) throws Exception {
		Cliente base = this.clienteService.mostrarCliente(favorito.getCliente().getId());
		Produto base1 = this.produtoService.buscarPorId(favorito.getProduto().getId());
		System.out.println(favorito.getCliente().getId());
		if(base1 == null || base == null) {
			throw new IllegalArgumentException("O produto ou o usuario nao existe em nossa base de dados ");
		}
		//favorito.getCliente().setNome(base.getNome());
		//favorito.setCliente(base);
		
		//favorito.setCliente(base);
		if(base.getMeusObjetos().size() <=20) {
			favorito.setProduto(base1);
			favorito.addCliente(base);
			this.listaRepository.save(favorito);
			base.addFavorito(base1);
			this.clienteService.alterarUsuario(favorito);
			return favorito;
		}
		throw new IllegalArgumentException("Usuario ja possui 20 produtos");

	}
	
	

	public Favorito mostrasFavorito(String id) {
		return this.listaRepository.findByClienteId(id);
		
	}
	
	
}
