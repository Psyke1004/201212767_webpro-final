package eGovframework.student.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eGovframework.student.service.StudentDAO;
import eGovframework.student.service.StudentService;
import eGovframework.student.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Inject
    private StudentDAO studentDAO;
    
	/**
	 * student을 등록한다.
	 * @param vo - 등록할 정보가 담긴 StudentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertStudent(StudentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	studentDAO.insertStudent(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
    }

    /**
	 * student 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return student 목록
	 * @exception Exception
	 */
    public List<StudentVO> selectStudent() throws Exception {
        return studentDAO.selectStudent();
    }

}
