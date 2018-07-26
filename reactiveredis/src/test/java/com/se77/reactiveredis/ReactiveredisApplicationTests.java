package com.se77.reactiveredis;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReactiveredisApplicationTests {

	@Autowired
    private PersonRepository personRepo;
	
	@Autowired
	private PersonRestController controller;
	
	@Test
	public void personsLoaded() {
		
		var persons = new ArrayList<Person>();
		personRepo.findAll().forEach( p -> persons.add(p));
		
		assertTrue(persons.size() == 3);
	}
	
	@Test
	public void personsReturned() {
		
		Flux<Person> result = controller.all();
		
		var persons = result.collectList().blockOptional();
		
		assertTrue(persons.get().size() == 3);
	}

}
