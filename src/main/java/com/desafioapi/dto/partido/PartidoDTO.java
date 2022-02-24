package com.desafioapi.dto.partido;

public class PartidoDTO {
	
	private String partido_sigla;
	private String partido_nome;
	
	public PartidoDTO() {
	}

	public PartidoDTO(String partido_sigla, String partido_nome) {
		this.partido_sigla = partido_sigla;
		this.partido_nome = partido_nome;
	}

	public String getPartido_sigla() {
		return partido_sigla;
	}

	public void setPartido_sigla(String partido_sigla) {
		this.partido_sigla = partido_sigla;
	}

	public String getPartido_nome() {
		return partido_nome;
	}

	public void setPartido_nome(String partido_nome) {
		this.partido_nome = partido_nome;
	}
	
	
	
	
	
	

}
