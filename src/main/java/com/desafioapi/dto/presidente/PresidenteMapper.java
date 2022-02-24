package com.desafioapi.dto.presidente;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Presidente;

public class PresidenteMapper {
	
	public static Presidente fromDTO(RegistroPresidenteDTO dto) {
		return new Presidente(null, dto.getNome(),dto.getCpf() ,EnderecoMapper.fromDTO(dto.getEndereco()),
				dto.getTelefone(), PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getFoto());
	}
	
	public static ConsultaPresidenteDTO fromEntity(Presidente presidente) {
		return new ConsultaPresidenteDTO(presidente.getId(), presidente.getNome(), presidente.getCpf(),
				EnderecoMapper.fromEntity(presidente.getEndereco()), presidente.getTelefone(),
				PartidoMapper.fromEntity(presidente.getPartido()), presidente.getProjeto_lei(), presidente.getFoto());
	}
	

}
