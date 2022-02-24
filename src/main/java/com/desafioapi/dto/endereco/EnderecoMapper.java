package com.desafioapi.dto.endereco;

import com.desafioapi.models.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTO(EnderecoDTO dto) {
		return new Endereco(dto.getLogradouro(), dto.getNumero(), dto.getNumero(), dto.getCep());
	}
	
	public static EnderecoDTO fromEntity(Endereco endereco) {
		return new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getCep());
	}

}
