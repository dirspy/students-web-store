package com.dirspy.webservice.endpoints;

import com.dirspy.webservice.model.Student;
import com.dirspy.webservice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Victor Moskvych
 */

@Component
@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    private StudentRepository repository;

    @Autowired
    public StudentEndpoint(StudentRepository repository) {
        this.repository = repository;
    }


    //TODO: Add filters
    @GET
    public Iterable<Student> getStudents() {
        return repository.findAll();
    }

    @GET
    @Path("/{studentId}")
    public Student getStudent(@PathParam("studentId") String id) {
        return repository.findOne(id);
    }

    @POST
    public Response addStudent(Student student, @Context UriInfo uriInfo) {

        Student newStudent = repository.save(student);
        String newId = newStudent.getId();
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                        .entity(newStudent)
                        .build();
    }

    @PUT
    @Path("/{studentId}")
    public Student updateStudent(@PathParam("studentId") String id, Student student) {
        student.setId(id);
        return repository.save(student);
    }

    @DELETE
    @Path("/{studentId}")
    public void deleteStudent(@PathParam("studentId") String id) {
        repository.delete(id);
    }

}
