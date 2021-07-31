package br.com.magalu.wishList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magalu.wishList.modelo.Cliente;
import br.com.magalu.wishList.modelo.Favorito;
import br.com.magalu.wishList.modelo.Produto;
import br.com.magalu.wishList.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ListadesejoService favoriteService;
	
	public Cliente criarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> mostrarTodos(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente mostrarCliente(String id) {
		return this.clienteRepository.findClienteById(id);
	}
	
	public String mostrarFavoritoCliente(String idCliente, String idProduto) {
		Cliente base = this.mostrarCliente(idCliente);
		Produto base1 = this.produtoService.buscarPorId(idProduto);
		int i =0;
		for(Object item : base.getMeusObjetos().toArray()) {		
			if(base.getMeusObjetos().get(i).getNome().equals(base1.getNome())) {
				return "O cliente possui o produto";
			}
			i++;
		}
		return "O cliente nao possui o produto em seus favoritos"; 
		
	}
	public Cliente deletarFavorito(String idCliente, String idProduto) throws Exception {
		Produto base1 = this.produtoService.buscarPorId(idProduto);
		Cliente base = this.mostrarCliente(idCliente);
		if(existeProdutoCliente(idCliente, idProduto)) {
			for(int j = 0; j <= base.getMeusObjetos().size(); j++){
		        Produto p = base.getMeusObjetos().get(j);
		        System.out.println(base.getMeusObjetos().get(j).getNome());
		        System.out.println(p.getNome());
		        if(p.getNome().equals(base1.getNome()))
		        {
		        	Favorito favorito = new Favorito();
		        	favorito = this.favoriteService.mostrasFavorito(idCliente);
		        	
		        	//base.getMeusObjetos().remove(p);
		        	
		        	base.getMeusObjetos().remove(j);
		        	//base.removeFavorito(p);
		        	this.alterarUsuario(favorito);
		            return null;
		        }

		    }
		}	
		throw new Exception("Não existe o produto");
	}
	
	
	
	public Cliente alterarUsuario(Favorito favorito) throws Exception{
		Cliente base = new Cliente();
		base = this.clienteRepository.findClienteById(favorito.getCliente().getId());
		System.out.println(base.getNome());
		if(base != null) {
			base.addFavorito(favorito.getProduto());
			return this.clienteRepository.save(base);
		}
		throw new Exception("Usuario não existe em nossa base de dados!");
		
	}
	
	public boolean existeProdutoCliente(String idCliente, String idProduto) {
		Cliente base = this.mostrarCliente(idCliente);
		Produto base1 = this.produtoService.buscarPorId(idProduto);
		int i =0;
		for(Object item : base.getMeusObjetos().toArray()) {		
			if(base.getMeusObjetos().get(i).getId().equals(base1.getId())) {
				//System.out.println(base.getMeusObjetos().get(i).getNome());
				//System.out.println(base1.getNome());
				//base.getMeusObjetos().remove(i);
				//base.removeFavorito(base1);
				return true;
			}
			i++;
		}
		return false; 
		
	}


}
