package com.se77.reactiveredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class PersonRestController {
    
	@Autowired
	private ReactiveRedisOperations<String, Person> personOps;

    
    @GetMapping("/persons")
    public Flux<Person> all() {
        
    	var persons = personOps.keys("*").flatMap( k -> personOps.opsForValue().get(k)); 
    	
    	return persons;
    }
}
