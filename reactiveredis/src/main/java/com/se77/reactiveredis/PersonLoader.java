package com.se77.reactiveredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class PersonLoader {
    @Autowired
    private PersonRepository personRepo;
    
    @PostConstruct
    public void initPosts() {
    	personRepo.deleteAll();
    	
        Stream.of("Heinz", "Kurt","Felix")
        	.map( name -> new Person(UUID.randomUUID().toString(), name ) )
        	.forEach(p -> personRepo.save(p));
    }
}