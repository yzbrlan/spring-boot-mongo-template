package xywu.top.edu.domain.student;

import xywu.top.edu.domain.student.persistence.entity.Student;

import java.util.List;

/**
 * @author xywu
 * @date 2020/09/24
 */
public interface StudentService {
    List<Student> getAllStudents();

    void updateStudent(Student student);

    Student insertStudent(Student student);

    void deleteStudent(String idCard);
}
