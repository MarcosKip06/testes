package com.desafioapi.dto.ministro;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Ministro;

public class MinistroMapper {
	
	public static Ministro fromDTO(RegistroMinistroDTO dto) {
		return new Ministro(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()),
				dto.getTelefone(), PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getFoto());
	}
	
	public static ConsultaMinistroDTO fromEntity(Ministro ministro) {
		return new ConsultaMinistroDTO(ministro.getId(), ministro.getNome(), ministro.getCpf(),
				EnderecoMapper.fromEntity(ministro.getEndereco()), ministro.getTelefone(),
				PartidoMapper.fromEntity(ministro.getPartido()), ministro.getProjeto_lei(), ministro.getFoto());
	}

}
