package ro.andrei.jersey.client.rest.client;

import java.util.List;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jvnet.hk2.annotations.Service;
import ro.andrei.jersey.client.rest.dto.Student;

@Service
public class StudentClient {
    private static final String SERVICE_URL = "http://localhost:8080/service/rest/student";

    private static final Client CLIENT = ClientBuilder.newClient();
    private static final WebTarget TARGET = CLIENT.target(SERVICE_URL);

    public List<Student> getAll() {
        return TARGET.request(MediaType.APPLICATION_JSON).get(List.class);
    }

    public Student getById(Long id) {
        return TARGET.path(id.toString()).request(MediaType.APPLICATION_JSON).get(Student.class);
    }

    public void deleteById(Long id) {
        Response response = TARGET.path(id.toString()).request().delete();
        if(response.getStatus() != Response.Status.OK.getStatusCode()
                && response.getStatus() != Response.Status.CREATED.getStatusCode()) {
            throw new InternalServerErrorException("Service replied: " + response.getStatus());
        }
    }

    public void create(Student student) {
        Response response = TARGET.request(MediaType.APPLICATION_JSON).post(Entity.json(student));
        if(response.getStatus() != Response.Status.OK.getStatusCode()
                && response.getStatus() != Response.Status.CREATED.getStatusCode()) {
            throw new InternalServerErrorException("Service replied: " + response.getStatus());
        }
    }
}
