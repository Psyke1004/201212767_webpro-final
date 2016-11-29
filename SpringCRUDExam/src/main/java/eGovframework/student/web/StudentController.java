package eGovframework.student.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import eGovframework.student.StudentVO;
import eGovframework.student.service.StudentService;

@Controller
@SessionAttributes(types = StudentVO.class)
public class StudentController {

	@Inject
	private StudentService studentService;

	@RequestMapping(value = "/student/StudentList.do")
	public String selectStudentList(Model model) throws Exception {

		List<?> studentList = studentService.selectStudent();
		model.addAttribute("resultList", studentList);

		return "/student/StudentList";
	}
	
    @RequestMapping("/student/addStudentView.do")
    public String addStudentView(Model model)
            throws Exception {
        model.addAttribute("studentVO", new StudentVO());
        return "/student/StudentRegister";
    }

	@RequestMapping("/student/addStudent.do")
	public String addStudent(StudentVO studentVO, SessionStatus status)
			throws Exception {
		studentService.insertStudent(studentVO);
		status.setComplete();
		return "forward:/student/StudentList.do";
	}

}
