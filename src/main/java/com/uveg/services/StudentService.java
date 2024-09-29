package com.uveg.services;

import com.uveg.models.Student;
import com.uveg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }//getStudents

    public Optional<Student> getStudent(Long id){

        return studentRepository.findById(id);
    }//getStudent

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }//saveStudent

    public void updateStudent(Student student){
        studentRepository.save(student);
    }//updateStudent

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }//deleteStudent


}//AlumnoService
