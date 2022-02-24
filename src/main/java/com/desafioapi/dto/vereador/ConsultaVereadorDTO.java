package com.desafioapi.dto.vereador;

import com.desafioapi.dto.endereco.EnderecoDTO;
import com.desafioapi.dto.partido.PartidoDTO;

public class ConsultaVereadorDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;
	private String telefone;
	private PartidoDTO partido;
	private Integer projeto_lei;
	private Integer processo;
	private String foto ="";
	
	public ConsultaVereadorDTO() {
	}

	public ConsultaVereadorDTO(Long id, String nome, String cpf, EnderecoDTO endereco, String telefone,
			PartidoDTO partido, Integer projeto_lei, Integer processo, String foto) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.partido = partido;
		this.projeto_lei = projeto_lei;
		this.processo = processo;
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public PartidoDTO getPartido() {
		return partido;
	}

	public void setPartido(PartidoDTO partido) {
		this.partido = partido;
	}

	public Integer getProjeto_lei() {
		return projeto_lei;
	}

	public void setProjeto_lei(Integer projeto_lei) {
		this.projeto_lei = projeto_lei;
	}

	public Integer getProcesso() {
		return processo;
	}

	public void setProcesso(Integer processo) {
		this.processo = processo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
	

}
