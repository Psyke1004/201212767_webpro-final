package egovframework.student.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.student.StudentVO;

@Repository("studentDAO")
public class StudentDAO extends EgovComAbstractDAO {

    public void insertStudent(StudentVO vo) throws Exception {
        insert("insert", vo);
    }
    
    public List<?> selectStudentList() throws Exception {
        return list("select");
    }

}
