package com.uveg.controllers;

import com.uveg.models.Student;
import com.uveg.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getEstudiantes(){
        return ResponseEntity.ok(studentService.getStudents());
    }//getEstudiantes

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstudiante(@PathVariable Long id){
        if(id==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ID no puede ser nulo");
        }
        Optional<Student> student = studentService.getStudent(id);
        if(!student.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro al estudiante con ID " + id);
        }
        return ResponseEntity.ok(student);
    }//getEstudiante

    @PostMapping
    public ResponseEntity<?> postEstudiante(@RequestBody Student student){
        Student newStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }//postEstudiante


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstudiante(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ID no puede ser nulo");
        }
        Optional<Student> student = studentService.getStudent(id);

        if(!student.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El estudiante con ID " + id +" no se encontró");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }//deleteEstudiante

    @PutMapping("/{id}")
    public ResponseEntity<?> putEstudiante(@PathVariable Long id, @RequestBody Student updateStudent){
        Optional<Student> existingStudent = studentService.getStudent(id);
        if(existingStudent.isPresent()){
            Student student = existingStudent.get();
            student.setNombre(updateStudent.getNombre());
            student.setEmail(updateStudent.getEmail());
            student.setFechaNac(updateStudent.getFechaNac());

            studentService.saveStudent(student);
            return ResponseEntity.ok("Estudiante actualizado correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al estudiante con ID " + id);
        }
    }
}//StudentController
