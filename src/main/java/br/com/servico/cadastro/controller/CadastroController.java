package br.com.servico.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.servico.cadastro.model.Usuario;
import br.com.servico.cadastro.repository.CadastroRepository;

/**
 * Rest Controller para API de cadastro.
 *
 * @author Lucas Bandeira
 */
@RestController
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	/**
	 * Método GET para listar as cadastros ativas
	 * 
	 * @return lista de cadastros ativas
	 */
	@GetMapping("/cadastros")
	List<Usuario> listarcadastros() {
		return cadastroRepository.findAll();
	}
	
	/**
	 * Método GET para visualizar um cadastro pelo id
	 * 
	 * @return cadastro
	 */
	@GetMapping("/cadastro/{id}")
	Usuario visualizarCadastro(@PathVariable Long id) {
		return cadastroRepository.findById(id);
	}
	
	/**
	 * Método POST para criar um cadastro
	 * 
	 * @return cadastro
	 */
	@PostMapping("/cadastro")
	ResponseEntity<Usuario> criarCadastro (@RequestBody Usuario cadastro) {
		if(cadastroRepository.findByEmail(cadastro.getEmail()) == null) {
			return ResponseEntity.ok().body(cadastroRepository.save(cadastro));
		}
		return ResponseEntity.badRequest().body(null);
	}

	/**
	 * Método DELETE para remover um cadastro pelo id
	 */
	@DeleteMapping("/cadastro/{id}")
	void removerCadastro(@PathVariable Long id) {
		cadastroRepository.deleteById(id);
	}	
	
}
