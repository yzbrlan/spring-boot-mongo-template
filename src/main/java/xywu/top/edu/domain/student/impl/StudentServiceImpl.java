package xywu.top.edu.domain.student.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xywu.top.edu.common.constant.ErrorCodes;
import xywu.top.edu.common.constant.SystemModules;
import xywu.top.edu.common.exception.impl.BadRequestException;
import xywu.top.edu.domain.student.StudentService;
import xywu.top.edu.domain.student.persistence.dao.StudentDao;
import xywu.top.edu.domain.student.persistence.entity.Student;

import java.util.List;

/**
 * @author xywu
 * @date 2020/09/24
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public void updateStudent(Student student) {
        if (StringUtils.isBlank(student.getIdCard()) || student.getAttrs().isEmpty()) {
            throw new BadRequestException(SystemModules.STUDENTS, ErrorCodes.BAD_REQUEST, ErrorCodes.BAD_REQUEST.getDefaultMessage());
        }
        studentDao.updateStudent(student.getIdCard(), student.getAttrs());
    }

    @Override
    public Student insertStudent(Student student) {
        if (StringUtils.isBlank(student.getIdCard())) {
            throw new BadRequestException(SystemModules.STUDENTS, ErrorCodes.BAD_REQUEST, "idCard needed");
        }
        return studentDao.insertStudent(student);
    }

    @Override
    public void deleteStudent(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            throw new BadRequestException(SystemModules.STUDENTS, ErrorCodes.BAD_REQUEST, "idCard needed");
        }
        studentDao.deleteStudent(idCard);
    }
}
