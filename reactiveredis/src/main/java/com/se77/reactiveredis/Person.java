package com.se77.reactiveredis;

import java.io.Serializable;


import org.springframework.data.redis.core.RedisHash;


import lombok.Data;

@RedisHash("Person")
@Data
public class Person implements Serializable {
   
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
    private String  id;
    private String name;
}
