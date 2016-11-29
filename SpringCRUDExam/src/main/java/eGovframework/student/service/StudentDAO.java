package eGovframework.student.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import eGovframework.student.StudentVO;

@Repository
public class StudentDAO {

	@Inject
	private SqlSession session;
	
	/**
	 * student을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 StudentVO
	 * @exception Exception
	 */
	public void insertStudent(StudentVO vo) throws Exception {
		session.insert("Student_SQL.insert", vo);
	}

	/**
	 * student 목록을 조회한다.
	 * 
	 * @return student 목록
	 * @exception Exception
	 */
	public List<StudentVO> selectStudent() throws Exception {
		return session.selectList("Student_SQL.select");
	}

}
