package br.com.magalu.wishList.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Favorito {
	
	@Id
	private String id;
	

	@DBRef
	private Cliente cliente;
	
	@DBRef
	private Produto produto;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String getId() {
		return id;
	}
	
	public Cliente addCliente(Cliente client) {
		this.cliente = client;
		return cliente;
	}

}
