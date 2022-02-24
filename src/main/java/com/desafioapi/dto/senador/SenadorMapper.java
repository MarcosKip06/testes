package com.desafioapi.dto.senador;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Senador;

public class SenadorMapper {
	
	public static Senador fromDTO(RegistroSenadorDTO dto) {
		return new Senador(null, dto.getNome(), dto.getCpf(),
				EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(),PartidoMapper.fromDTO(dto.getPartido()),
				dto.getProjeto_lei(), dto.getFoto());
	}
	
	public static ConsultaSenadorDTO fromEntity(Senador senador) {
		return new ConsultaSenadorDTO(senador.getId(), senador.getNome(),senador.getCpf() ,
				EnderecoMapper.fromEntity(senador.getEndereco()), senador.getTelefone(),
				PartidoMapper.fromEntity(senador.getPartido()), senador.getProjeto_lei(), senador.getFoto());
	}
	

}
