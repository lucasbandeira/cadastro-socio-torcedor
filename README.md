# Cadastro sócio-torcedor
API REST para cadastro de sócio-torcedor.

*O sistema de cadastro de sócio-torcedor não pode ter o mesmo email cadastrado mais de uma vez. O usuário cadastrado poderará se associar a uma campanha apartir da API de [campanha](https://github.com/lucasbandeira/campanha-socio-torcedor)

Segue a baixo o cenário de criação do mesmo [imagem do cenário](https://drive.google.com/file/d/18Ip-0ZfYtVPQVjrMx8zBj9g0PwItU-O9/view?usp=sharing)
```
    /**
     * Cenário: Eu quero cadastrar um socio torcedor caso o mesmo não possua cadastro
     * 
     * Dado seja cadastrado um novo socio torcedor
     * Então verifico se o mesmo foi cadastrado com sucesso
     * Caso o mesmo já tenha sido cadastrado verifico se o status code é 400
     */
    @SuppressWarnings("serial")
	@Test
	public void testa2CenarioDeCriacaoDeCampanhas() {
    	
		Map<String,Object> usuario = new HashMap<>();
		usuario.put("email", "jucastrocesar@gmail.com");
		usuario.put("nome", "Juliana Castro");
        usuario.put("dataNascimento", "1994-08-18");
        usuario.put("time", new HashMap<String, Object>() {{
            put("id", "1");
            put("nome", "Ceara");
        }});
        
        if(given()
			.contentType("application/json;text/plain")
			.body(usuario)
			.when().post("/cadastro").getStatusCode() == 200 ) {
	        	given().when().get("/cadastros").then()
	    		.body("nome", hasItems("Juliana Castro"));
        } else {
        	given()
			.contentType("application/json;text/plain")
			.body(usuario)
			.when().post("/cadastro").then()
	    	.statusCode(400);
        }
		
	}
```

### GET /cadastros
[imagem da lista de sócios toredores](https://drive.google.com/file/d/1WhKrXqMiq8YKhie0YQyxGcoUM1VIdy9b/view?usp=sharing)


### GET /campanha/:id
[imagem do detalhe de um sócio toredor](https://drive.google.com/file/d/1KGU8QerpTthFWn4FOMgNdQllX7tgPG2C/view?usp=sharing)


### POST /campanha
[image da criação de um sócio toredor](https://drive.google.com/file/d/1G-d-gBRQ0VUGof2cptMjWQB-AmLkHwRF/view?usp=sharing)


### DELETE /campanha/:id
[image da remoção de um sócio toredor](https://drive.google.com/file/d/1I8_2iJ075LwRXLHO8d8QPgLYtIvusoyf/view?usp=sharing)


# Tecnologias e frameworks
- Java 8
- Spring Boot
- Postgres
- TomCat 9.0.21
- Rest Assured - Ferramenta BDD para teste de dos end-points
