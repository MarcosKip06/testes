package com.desafioapi.dto.deputado;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Deputado;

public class DeputadoMapper {
	
	public static Deputado fromDTO(RegistroDeputadoDTO dto) {
		return new Deputado(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()),
				dto.getTelefone(), dto.getProcesso(), PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getLider(), dto.getFoto());
	}
	
	public static ConsultaDeputadoDTO fromEntity(Deputado deputado) {
		return new ConsultaDeputadoDTO(deputado.getId(),deputado.getNome(), deputado.getCpf(), EnderecoMapper.fromEntity(deputado.getEndereco()),
				deputado.getTelefone(), deputado.getProcesso(), PartidoMapper.fromEntity(deputado.getPartido()), deputado.getProjeto_lei(), deputado.getLider(), deputado.getFoto());
	}

}
