package xywu.top.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xywu.top.edu.domain.student.StudentService;
import xywu.top.edu.domain.student.persistence.entity.Student;

import java.util.List;

/**
 * @author xywu
 * @date 2020/09/24
 */
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping(value = "/student")
    public ResponseEntity<Void> deleteStudent(@RequestParam("idCard") String idCard) {
        studentService.deleteStudent(idCard);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/student")
    public ResponseEntity<Void> insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/student")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
