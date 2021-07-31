package br.com.magalu.wishList.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.magalu.wishList.modelo.Cliente;
import br.com.magalu.wishList.modelo.Produto;


public class WishlistTestService {
	
	@Autowired
	private ListadesejoService listaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	void DeveRetornarSucessoCasoUsuarioTenhaOProdutoComoFavorito() {

		Cliente base = new Cliente();
		base.setNome("Kayque");
		Produto base1 = new Produto();
		base1.setNome("Celular motorolla");
		base1.setPreco(new BigDecimal (720.0));
		ArrayList<Produto> item = new ArrayList<Produto>();
		item.add(base1);
		base.setMeusObjetos(item);
		
		assertEquals("Celular motorolla",base.getMeusObjetos().get(0).getNome());
	}
	
	@Test
	void DeveRetornarErroCasoExcluiProdutoDoUsuario() {

		Cliente base = new Cliente();
		base.setNome("Kayque");
		Produto base1 = new Produto();
		base1.setNome("Celular motorolla");
		base1.setPreco(new BigDecimal (720.0));
		ArrayList<Produto> item = new ArrayList<Produto>();
		item.add(base1);
		base.setMeusObjetos(item);
		base.removeFavorito(base1);
		
		assertEquals("Celular motorolla",base.getMeusObjetos().get(0).getNome());
	}

	

}
