package com.se77.reactiveredis;

import org.springframework.data.repository.*;

public interface StudentRepository extends CrudRepository<Student, String> {}
