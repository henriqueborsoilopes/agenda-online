package com.coffecode.agendaonline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffecode.agendaonline.entities.Usuario;
import com.coffecode.agendaonline.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Long id) {
		Usuario user = repository.getById(id);
		return user;
	}
}
