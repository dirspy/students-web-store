package com.dirspy.webservice.repositories;

import com.dirspy.webservice.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * @author Victor Moskvych
 */
public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);

}