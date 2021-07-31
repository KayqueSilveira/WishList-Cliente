# Wishlist-cliente

Cadastro de clientes com uma lista de produtos como sendo seus favoritos. 

Tecnologias:

* SpringBoot
* Spring Data MongoDB
* Spring Web

## Executar a aplicação

Para rodar a aplicação na sua IDE, execute a classe main WishListApplication.java.
Obs: Para acessar as iformações do banco MongoDB acesse: src/main/resources/application.properties

Ao subir pode-se acessar:

```
Para verificar todos os clientes e seus favoritos:
http://localhost:8080/cliente
Para verificar a lista de favoritos de um determinado cliente:
http//localhost:8080/cliente/<id do cliente>
Para verificar se existe um determinado produto no cliente:
http//localhost:8080/cliente/<id do cliente>/<id do produto>
Para verificar todos os produtos:
http://localhost:8080/produto
Para criar um novo produto:
http://localhost:8080/produto/criarProduto
Para criar um novo favorito executando com o Postman deve colocar na ResponseBody o id do Cliente e o id do Produto:
http://localhost:8080/favoritos


```


## Banco de Dados

Foi utilizando o banco MongoDB. 

```
database = magalu
username = kayque
password = 123456
```

## Testes

Foi utilizado JUnit para os testes, e ocorrerão na camada WishlistService
