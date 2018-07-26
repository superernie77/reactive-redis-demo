package com.se77.reactiveredis;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

interface PersonRepository extends KeyValueRepository<Person, String>  {

}
