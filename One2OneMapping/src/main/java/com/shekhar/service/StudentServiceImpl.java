package com.shekhar.service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.shekhar.DTO.StudentDTO;
import com.shekhar.entity.Student;
import com.shekhar.repository.StudentRepository;
import com.shekhar.utils.StudentUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentDTO saveStudent(StudentDTO student) {

		return StudentUtils.map(repository.save(StudentUtils.map(student)));

	}

	@Override
	public StudentDTO deleteStudentById(Long studentId) {
		StudentDTO dto = new StudentDTO();
		Student student = repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
		BeanUtils.copyProperties(student, dto);
		repository.delete(student);
		return dto;
	}

	@Override
	public StudentDTO partialUpdateStudent(Long studentId, Map<String, Object> studentInfo) {

		Student student2 = repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

		studentInfo.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Student.class, key);
			field.setAccessible(true);

			try {
				if (field.getType().equals(LocalDate.class) && value instanceof String) {
					value = LocalDate.parse((String) value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				} else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
					field.set(student2, Boolean.parseBoolean(value.toString()));
				}
				ReflectionUtils.setField(field, student2, value);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(student2, dto);

		Student save = repository.save(student2);
		return StudentUtils.map(save);

	}

	@Override
	public StudentDTO updateStudent(Long studentId, StudentDTO dto) {
		Student student2 = repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

		BeanUtils.copyProperties(dto, student2);
		student2.setStudentId(studentId);
		Student save = repository.save(student2);
		return StudentUtils.map(save);

	}

	@Override
	public StudentDTO getStudentById(Long studentId) {

		return StudentUtils
				.map(repository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found")));

	}

	@Override
	public List<StudentDTO> getAllStudent() {

		return repository.findAll().stream().map(StudentUtils::map).toList();

	}

}
