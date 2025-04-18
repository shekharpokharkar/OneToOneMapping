package com.shekhar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.DTO.StudentDTO;
import com.shekhar.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO student) {
		StudentDTO dto = studentService.saveStudent(student);
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.CREATED);
	}

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<List<StudentDTO>> getAllStudent() {
		List<StudentDTO> dto = studentService.getAllStudent();
		return new ResponseEntity<List<StudentDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId) {
		StudentDTO dto = studentService.getStudentById(studentId);
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<StudentDTO> updateStudent(@PathVariable("studentId") Long studentId,
			@RequestBody StudentDTO student) {
		StudentDTO dto = studentService.updateStudent(studentId, student);
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.ACCEPTED);
	}

	@PatchMapping(value = "/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<StudentDTO> partialUpdateStudent(@PathVariable("studentId") Long studentId,
			@RequestBody Map<String, Object> studentInfo) {
		StudentDTO dto = studentService.partialUpdateStudent(studentId, studentInfo);
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<StudentDTO> deleteStudentById(@PathVariable("studentId") Long studentId) {
		StudentDTO dto = studentService.deleteStudentById(studentId);
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.OK);
	}

}
