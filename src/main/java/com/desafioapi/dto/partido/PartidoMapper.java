package com.desafioapi.dto.partido;

import com.desafioapi.models.Partido;

public class PartidoMapper {
	
	public static Partido fromDTO(PartidoDTO dto) {
		return new Partido(dto.getPartido_sigla(), dto.getPartido_nome());
	}
	
	public static PartidoDTO fromEntity(Partido partido) {
		return new PartidoDTO(partido.getPartido_sigla(), partido.getPartido_nome());
	}

}
