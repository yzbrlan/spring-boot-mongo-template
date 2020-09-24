package xywu.top.edu.domain.student.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xywu.top.edu.domain.student.persistence.entity.Student;

/**
 * @author xywu
 * @date 2020/09/24
 */
public interface MongoStudentDao extends MongoRepository<Student,String> {
    Student findStudentByIdCard(String idCard);
}
