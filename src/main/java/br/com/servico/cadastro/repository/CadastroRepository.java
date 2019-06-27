package br.com.servico.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.servico.cadastro.model.Usuario;

/**
 * Repository para Entidade Cadastro.
 *
 * @author Lucas Bandeira
 */
public interface CadastroRepository extends Repository <Usuario, Long> {
	
	/**
	 * Método que retorna um Cadastro pelo id.
	 * 
	 * @param id
	 * @return Cadastro pelo id
	 */
	Usuario findById(Long id);
	
	/**
	 * Método que retorna um Cadastro pelo email.
	 * 
	 * @param email
	 * @return Cadastro pelo email
	 */
	Usuario findByEmail(String email);
	
	/**
	 * Método que retorna todas as Cadastros
	 * 
	 * @return lista de Cadastros
	 */
	List<Usuario> findAll();
	
	/**
	 * Método que salva um Cadastro.
	 * 
	 * @param Cadastro
	 * @return Cadastro salvo
	 */
	Usuario save(Usuario Cadastro);
	
	/**
	 * Método que remove um Cadastro por id.
	 * 
	 * @param id
	 * @return Cadastro removida
	 */
	Usuario deleteById(Long id);
	
}
