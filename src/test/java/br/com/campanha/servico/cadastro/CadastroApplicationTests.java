package br.com.campanha.servico.cadastro;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.RestAssured;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroApplicationTests {

	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }
	
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

}
