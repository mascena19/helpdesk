package com.rm.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
