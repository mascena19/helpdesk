package com.rm.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Rodrigo Mascena", "680.286.770-29", "mascena@gmail.com", encoder.encode("123456"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Paulo Mascena", "721.485.900-90", "mascena198@gmail.com", encoder.encode("123456"));
		tec2.addPerfil(Perfil.ADMIN);
		
		Tecnico tec3 = new Tecnico(null, "Paulo Ricardo", "873.093.930-58", "mascena1985@gmail.com", encoder.encode("123456"));
		tec3.addPerfil(Perfil.ADMIN);
	
		Cliente cli1 = new Cliente(null, "Elisa Smith", "870.204.830-20", "raquel@gmail.com", encoder.encode("123456"));
		Cliente cli2 = new Cliente(null, "Elisa Smith", "978.287.370-50", "raquel2@gmail.com", encoder.encode("123456"));
	
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO , "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO , "Chamado 02", "Segundo Chamado", tec2, cli2);
					
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		clienteRepository.saveAll(Arrays.asList(cli2));
		chamadoRepository.saveAll(Arrays.asList(c2));
		
		tecnicoRepository.saveAll(Arrays.asList(tec3));
	}
}
