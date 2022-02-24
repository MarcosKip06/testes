package com.desafioapi.dto.governador;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Governador;

public class GovernadorMapper {
	
	public static Governador fromDTO(RegistroGovernadorDTO dto) {
		return new Governador(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()),
				dto.getTelefone(), PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getProcesso(), dto.getFoto());
	}
	
	public static ConsultaGovernadorDTO fromEntity(Governador governador) {
		return new ConsultaGovernadorDTO(governador.getId(), governador.getNome(), governador.getCpf(), 
				EnderecoMapper.fromEntity(governador.getEndereco()), governador.getTelefone(), PartidoMapper.fromEntity(governador.getPartido()),
				governador.getProjeto_lei(), governador.getProcesso(), governador.getFoto());
	}

}
