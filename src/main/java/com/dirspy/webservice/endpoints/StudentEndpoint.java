package com.dirspy.webservice.endpoints;

import com.dirspy.webservice.model.Student;
import com.dirspy.webservice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * @author Victor Moskvych
 */

@Component
@Path("/students")
@Consumes("application/json")
@Produces("application/json")
public class StudentEndpoint {

    private StudentRepository repository;

    @Autowired
    public StudentEndpoint(StudentRepository repository) {
        this.repository = repository;
    }

    @GET
    public Iterable<Student> getStudents() {
        return repository.findAll();
    }

    @POST
    public void addStudent(Student student) {
        repository.save(student);
    }

}
