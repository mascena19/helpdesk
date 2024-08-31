package com.rm.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
