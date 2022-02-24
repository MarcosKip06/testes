package com.desafioapi.dto.prefeito;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Prefeito;

public class PrefeitoMapper {
	
	public static Prefeito fromDTO(RegistroPrefeitoDTO dto) {
		return new Prefeito(null, dto.getNome(),
				dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(),
				PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getFoto());
	}
	
	public static ConsultaPrefeitoDTO fromEntity(Prefeito prefeito) {
		return new ConsultaPrefeitoDTO(prefeito.getId(),prefeito.getNome() ,prefeito.getCpf() ,
				EnderecoMapper.fromEntity(prefeito.getEndereco()) ,prefeito.getTelefone() 
				,PartidoMapper.fromEntity(prefeito.getPartido()) ,prefeito.getProjeto_lei() ,prefeito.getFoto() );
	}

}
