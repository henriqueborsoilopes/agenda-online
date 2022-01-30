package com.coffecode.agendaonline;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coffecode.agendaonline.entities.Agenda;
import com.coffecode.agendaonline.entities.Usuario;
import com.coffecode.agendaonline.repositories.AgendaRepository;
import com.coffecode.agendaonline.repositories.UsuarioRepository;

@SpringBootApplication
public class AgendaonlineApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AgendaonlineApplication.class, args);
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario usuario1 = new Usuario(null, "henriqueborsoilopes@gmail.com", "ahbsdvlhbsalhdb");
		
		Agenda agenda1 = new Agenda(null, "CoffeCode", sdf.parse("05/03/2022 10:30"), "Rua Dom Pedro II, 541, Catanduvas - PR", "Reunião sobre o desenvolvimento do site Agenda On-line", usuario1);
		
		agenda1.getEmails().addAll(Arrays.asList("ricardorolim27@gmail.com"));
		
		usuario1.getAgendas().addAll(Arrays.asList(agenda1));
		
		usuarioRepository.saveAll(Arrays.asList(usuario1));
		agendaRepository.saveAll(Arrays.asList(agenda1));
	}
}
