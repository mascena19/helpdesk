package com.rm.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
