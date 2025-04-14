package com.shekhar.service;

import java.util.List;
import java.util.Map;

import com.shekhar.DTO.StudentDTO;

public interface StudentService {

	StudentDTO saveStudent(StudentDTO student);

	StudentDTO deleteStudentById(Long studentId);

	StudentDTO partialUpdateStudent(Long studentId, Map<String, Object> studentInfo);

	StudentDTO updateStudent(Long studentId, StudentDTO student);

	StudentDTO getStudentById(Long studentId);

	List<StudentDTO> getAllStudent();

}
