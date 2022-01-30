package com.coffecode.agendaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffecode.agendaonline.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
