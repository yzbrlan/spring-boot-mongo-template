package xywu.top.edu.domain.student.persistence.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import xywu.top.edu.common.constant.ErrorCodes;
import xywu.top.edu.common.constant.SystemModules;
import xywu.top.edu.common.exception.impl.BadRequestException;
import xywu.top.edu.common.exception.impl.ResourceNotFoundException;
import xywu.top.edu.domain.student.persistence.entity.Student;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author xywu
 * @date 2020/09/24
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Resource
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME = "student";

    @Override
    public List<Student> findAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student findStudentByIdCard(String idCard) {
        Query query = new Query(Criteria.where("idCard").is(idCard));
        List<Student> students = mongoTemplate.find(query, Student.class, COLLECTION_NAME);
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public Student insertStudent(Student student) {
        if (findStudentByIdCard(student.getIdCard()) != null) {
            throw new BadRequestException(SystemModules.STUDENTS, ErrorCodes.BAD_REQUEST, "idCard is already exiting " + student.getIdCard());
        }
        return mongoTemplate.insert(student,COLLECTION_NAME);
    }

    @Override
    public boolean deleteStudent(String idCard) {
        Student student = findStudentByIdCard(idCard);
        if (student == null) {
            throw new ResourceNotFoundException(SystemModules.STUDENTS, ErrorCodes.RESOURCE_NOT_FOUND, "idCard not found " + idCard);
        }
        return mongoTemplate.remove(student, COLLECTION_NAME).getDeletedCount() > 0;
    }

    @Override
    public boolean updateStudent(String idCard, HashMap<String, String> hashMap) {
        Student student = findStudentByIdCard(idCard);
        if (student == null) {
            throw new ResourceNotFoundException(SystemModules.STUDENTS, ErrorCodes.RESOURCE_NOT_FOUND, "idCard not found " + idCard);
        }
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update();
        hashMap.forEach((k, v) -> update.set("attrs." + k, v));
        return mongoTemplate.updateFirst(query, update, Student.class, COLLECTION_NAME).getModifiedCount() > 0;
    }
}
