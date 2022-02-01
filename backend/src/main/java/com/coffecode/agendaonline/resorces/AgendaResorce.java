package com.coffecode.agendaonline.resorces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffecode.agendaonline.entities.Agenda;
import com.coffecode.agendaonline.services.AgendaService;

@RestController
@RequestMapping(value="/agendas")
public class AgendaResorce {
	
	@Autowired
	private AgendaService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public void insert(@Valid @RequestBody Agenda obj) {
		service.insert(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Agenda> findAll(){
		List<Agenda> agendas = service.findAll();
		return agendas;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void update(@Valid @RequestBody Agenda obj, @PathVariable Long id) {
		service.update(obj, id);
	}
}
