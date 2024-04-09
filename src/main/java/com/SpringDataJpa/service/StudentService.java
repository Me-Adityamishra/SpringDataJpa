package com.SpringDataJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringDataJpa.dao.StudentRepository;
import com.SpringDataJpa.entity.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(student.getName());
            student.setCity(student.getCity());
            return studentRepository.save(student);
        }
        return null;
    }
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
    public List<Student> getStudentsByCity(String city) {
        return studentRepository.findByCity(city);
    }
}
