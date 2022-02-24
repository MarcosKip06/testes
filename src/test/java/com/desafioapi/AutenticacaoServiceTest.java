package com.desafioapi;




import com.desafioapi.controllers.DeputadoController;
import com.desafioapi.dto.deputado.RegistroDeputadoDTO;
import com.desafioapi.models.Deputado;
import com.desafioapi.models.Usuario;
import com.desafioapi.services.UsuarioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AutenticacaoServiceTest {

    @Autowired
    UsuarioService usuarioService;


    @Test
    public void deveSalvarUmUsuario(){
        Usuario usuario = new Usuario();
        usuario.setUsuario("Marcos");
        usuario.setSenha("12345");





    }



}
