package com.desafioapi.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_deputado")
public class Deputado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@CPF
	private String cpf;
	@Embedded
	private Endereco endereco;
	
	private String telefone;
	
	private String processo;
	
	@Embedded
	private Partido partido;
	
	private Integer projeto_lei;
	
	private String lider;
	
	private String foto ="";

	public Deputado() {
	}

	public Deputado(Long id, String nome, String cpf, Endereco endereco, String telefone, String processo,
			Partido partido, Integer projeto_lei, String lider, String foto) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.processo = processo;
		this.partido = partido;
		this.projeto_lei = projeto_lei;
		this.lider = lider;
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Integer getProjeto_lei() {
		return projeto_lei;
	}

	public void setProjeto_lei(Integer projeto_lei) {
		this.projeto_lei = projeto_lei;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
	
	
	

}
