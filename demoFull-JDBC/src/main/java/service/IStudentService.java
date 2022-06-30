package service;

import model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    void create(Student student);

    void edit(Student student);

    Student findById(int id);

    List<Student> findByName(String name);

    void delete();


}
