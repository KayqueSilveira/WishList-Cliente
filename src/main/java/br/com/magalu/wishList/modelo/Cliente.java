package br.com.magalu.wishList.modelo;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {
	
	@Id
	private String id;
	private String nome;	
	@DBRef
	private ArrayList<Produto> meusObjetos = new ArrayList<Produto>();


	public ArrayList<Produto> getMeusObjetos() {
		return meusObjetos;
	}

	public void setMeusObjetos(ArrayList<Produto> meusObjetos) {
		this.meusObjetos = meusObjetos;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addFavorito(Produto base1) {
		this.meusObjetos.add(base1);
	}
	
	public void removeFavorito(Produto base1) {
		this.meusObjetos.remove(base1);
	}

	
}
