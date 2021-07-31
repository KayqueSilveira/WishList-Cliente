package br.com.magalu.wishList.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.magalu.wishList.modelo.Favorito;

public interface WishlistRepository extends MongoRepository<Favorito, String> {
	
	
	public List<Favorito> findAllFavoritoById(String id);
	//public List<Favorito> findByClienteId(String id);
	public Favorito findByProdutoId(String id);
	public boolean existsByProdutoId(String id);
	//public boolean existsByClienteId(String id);
	public Favorito deleteProdutoById(String id);

	public void deleteFavoritoById(String id);

	public Favorito findFavoritoById(String id);
	
	public Favorito findByClienteId(String id);
}
