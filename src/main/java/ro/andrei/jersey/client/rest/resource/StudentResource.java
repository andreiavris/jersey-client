package ro.andrei.jersey.client.rest.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ro.andrei.jersey.client.rest.dto.Student;
import ro.andrei.jersey.client.service.StudentService;

@Path("student")
public class StudentResource {

    @Inject
    private StudentService studentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GET
    @Path("/{id}")
    public Student getById(@PathParam("id") Long id) {
        return studentService.getById(id);
    }

    @POST
    public Response create(Student student) {
        studentService.create(student);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        studentService.delete(id);
        return Response.ok().build();
    }
}
