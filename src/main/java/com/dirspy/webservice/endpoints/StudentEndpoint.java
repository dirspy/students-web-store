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

    @GET
    @Path("/{studentId}")
    public Student getStudentById(@PathParam("studentId") String id) {
        return repository.findOne(id);
    }

    @POST
    public void addStudent(Student student) {
        repository.save(student);
    }

    @PUT
    public Student updateStudent(Student student) {
        if (repository.findOne(student.getId()) != null)
            return repository.save(student);
        return null;
    }

    @DELETE
    @Path("/{studentId}")
    public void deleteStudent(@PathParam("studentId") String id) {
        repository.delete(id);
    }

}
