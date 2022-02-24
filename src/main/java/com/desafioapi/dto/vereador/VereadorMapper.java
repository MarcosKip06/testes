package com.desafioapi.dto.vereador;

import com.desafioapi.dto.endereco.EnderecoMapper;
import com.desafioapi.dto.partido.PartidoMapper;
import com.desafioapi.models.Vereador;

public class VereadorMapper {
	
	public static Vereador fromDTO(RegistroVereadorDTO dto) {
		return new Vereador(null, dto.getNome(),
				dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(),
				PartidoMapper.fromDTO(dto.getPartido()), dto.getProjeto_lei(), dto.getProcesso(), dto.getFoto());
	}
	
	public static ConsultaVereadorDTO fromEntity(Vereador vereador) {
		return new ConsultaVereadorDTO(vereador.getId(), vereador.getNome(), vereador.getCpf(),
				EnderecoMapper.fromEntity(vereador.getEndereco()), vereador.getTelefone(),
				PartidoMapper.fromEntity(vereador.getPartido()), vereador.getProjeto_lei(), vereador.getProcesso(), vereador.getFoto());
	}

}
