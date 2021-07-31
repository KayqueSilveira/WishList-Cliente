package br.com.magalu.wishList.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.magalu.wishList.modelo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

	Cliente findClienteById(String id);
	//public boolean existsByFavoritosId(String id);


}
