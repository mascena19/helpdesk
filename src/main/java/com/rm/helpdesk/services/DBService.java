package com.rm.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.helpdesk.domain.Chamado;
import com.rm.helpdesk.domain.Cliente;
import com.rm.helpdesk.domain.Tecnico;
import com.rm.helpdesk.domain.enums.Perfil;
import com.rm.helpdesk.domain.enums.Prioridade;
import com.rm.helpdesk.domain.enums.Status;
import com.rm.helpdesk.repositories.ChamadoRepository;
import com.rm.helpdesk.repositories.ClienteRepository;
import com.rm.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Rodrigo Mascena", "00100200399", "mascena@gmail.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
	
		Cliente cli1 = new Cliente(null, "Elisa Smith", "00200300488", "raquel@gmail.com", "123654");
	
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO , "Chamado 01", "Segundo Chamado", tec1, cli1);
					
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
