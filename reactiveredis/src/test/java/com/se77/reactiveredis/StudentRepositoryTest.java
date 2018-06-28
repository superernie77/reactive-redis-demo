package com.se77.reactiveredis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.se77.reactiveredis.Student.Gender;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setGender(Gender.MALE);
		student.setGrade(1);
		student.setName("Ernie");
	    Student result = studentRepository.save(student);
	    
	    assertNotNull(result);
	}

}
