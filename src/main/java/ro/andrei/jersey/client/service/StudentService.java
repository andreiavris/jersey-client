package ro.andrei.jersey.client.service;

import java.util.List;
import javax.inject.Inject;
import org.jvnet.hk2.annotations.Service;
import ro.andrei.jersey.client.rest.client.StudentClient;
import ro.andrei.jersey.client.rest.dto.Student;

@Service
public class StudentService {

    @Inject
    private StudentClient studentClient;

    public List<Student> getAll() {
        return studentClient.getAll();
    }

    public Student getById(Long id) {
        return studentClient.getById(id);
    }

    public void create(Student student) {
        studentClient.create(student);
    }

    public void delete(Long id) {
        studentClient.deleteById(id);
    }
}
