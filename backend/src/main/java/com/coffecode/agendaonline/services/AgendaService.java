package com.coffecode.agendaonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffecode.agendaonline.entities.Agenda;
import com.coffecode.agendaonline.entities.Usuario;
import com.coffecode.agendaonline.repositories.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
		
	public void insert(Agenda obj) {//Data como null, pensar em como ajustar essa variável.
		Usuario user = usuarioService.findById(obj.getUsuario().getId());
		Agenda newAgenda = new Agenda(null, obj.getTitulo(), null, obj.getLocal(), obj.getDescricao(), user);
		repository.save(newAgenda);
	}
	
	public List<Agenda> findAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Agenda obj, Long id) {
		Agenda agenda = repository.getById(id);
		agenda.setTitulo(obj.getTitulo());
		agenda.setLocal(obj.getLocal());
		agenda.setDescricao(obj.getDescricao());
		repository.save(agenda);
	}
}
