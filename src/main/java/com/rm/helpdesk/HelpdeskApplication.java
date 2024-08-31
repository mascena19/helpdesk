package com.rm.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rm.helpdesk.domain.Chamado;
import com.rm.helpdesk.domain.Cliente;
import com.rm.helpdesk.domain.Tecnico;
import com.rm.helpdesk.domain.enums.Perfil;
import com.rm.helpdesk.domain.enums.Prioridade;
import com.rm.helpdesk.domain.enums.Status;
import com.rm.helpdesk.repositories.ChamadoRepository;
import com.rm.helpdesk.repositories.ClienteRepository;
import com.rm.helpdesk.repositories.TecnicoRepository;


@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Rodrigo Mascena", "00100200399", "mascena@gmail.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Elisa Smith", "00200300488", "elisa@gmail.com", "123654");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO , "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
					
	}

}
