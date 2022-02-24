package com.desafioapi;

import com.desafioapi.dto.deputado.RegistroDeputadoDTO;
import com.desafioapi.dto.endereco.EnderecoDTO;
import com.desafioapi.dto.partido.PartidoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    RegistroDeputadoDTO dto;

    @Before
    public void setup(){
        dto = new RegistroDeputadoDTO();
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        PartidoDTO partidoDTO = new PartidoDTO();

        dto.setNome("Marcos");
        dto.setCpf("88099718330");
        dto.setTelefone("81999999999");
        enderecoDTO.setLogradouro("Rua do teste");
        enderecoDTO.setCep("1111111111");
        enderecoDTO.setNumero("6");
        enderecoDTO.setComplemento("casa");
        dto.setProcesso("0");
        dto.setLider("Franco");
        dto.setProjeto_lei(1);
        partidoDTO.setPartido_sigla("MDB");
        partidoDTO.setPartido_nome("Nome");
    }

    @Test
    public void deveBuscarTodosOsDeputados() throws Exception{
        mockMvc.perform(get("/v1/deputados"))
                .andExpect(status().isOk());

    }

    @Test
    public void deveBuscarDeputadosPorId() throws Exception{
        mockMvc.perform(get("/v1/deputados/7"))
                .andExpect(status().isOk());

    }

    @Test
    public void deveSalvarDeputado() throws Exception {
        mockMvc.perform(post("/v1/deputados")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

    }



}
