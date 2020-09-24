package xywu.top.edu.domain.student.persistence.dao;

import xywu.top.edu.domain.student.persistence.entity.Student;

import java.util.HashMap;
import java.util.List;

/**
 * @author xywu
 * @date 2020/09/24
 */
public interface StudentDao {
    List<Student> findAllStudents();

    Student findStudentByIdCard(String idCard);

    Student insertStudent(Student student);

    boolean deleteStudent(String idCard);

    boolean updateStudent(String idCard,HashMap<String,String> hashMap);
}
