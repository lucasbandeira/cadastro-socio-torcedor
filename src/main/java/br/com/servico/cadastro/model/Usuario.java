package br.com.servico.cadastro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Model para Entidade Usuario.
 *
 * @author Lucas Bandeira
 */
@Entity
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private LocalDate dataNascimento;
	
	@OneToOne
	@JoinColumn(name = "id_time")
	private Time time;
	
	/**
	 * Método get do atributo nome
	 * 
	 * @return nome Valor do atributo
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método set do atributo nome
	 * 
	 * @param nome Valor para setar no atributo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método get do atributo email
	 * 
	 * @return email Valor do atributo
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método set do atributo email
	 * 
	 * @param email Valor para setar no atributo
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método get do atributo dataNascimento
	 * 
	 * @return dataNascimento Valor do atributo
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	/**
	 * Método set do atributo dataFinal
	 * 
	 * @param dataFinal Valor para setar no atributo
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * Método get do atributo id
	 * 
	 * @return id Valor do atributo
	 */
	public Long getId() {
		return id;
	}

	/**
	 *  Método get do atributo time
	 * 
	 * @return time Valor do atributo
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Método set do atributo time
	 * 
	 * @param time Valor para setar no atributo
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	
}
