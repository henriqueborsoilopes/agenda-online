package com.coffecode.agendaonline.resorces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody Agenda obj) {
		service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Agenda>> findAll(){
		List<Agenda> agendas = service.findAll();
		return ResponseEntity.ok().body(agendas);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Agenda obj, @PathVariable Long id) {
		service.update(obj, id);
		return ResponseEntity.ok().build();
	}
}
