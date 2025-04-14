package com.shekhar.utils;

import org.springframework.beans.BeanUtils;

import com.shekhar.DTO.AddressDTO;
import com.shekhar.DTO.StudentDTO;
import com.shekhar.entity.Address;
import com.shekhar.entity.Student;

public interface StudentUtils {

	public static Student map(StudentDTO dto) {
		Student student = new Student();
		BeanUtils.copyProperties(dto, student);
		if (dto.getAddressdto() != null) {
			Address add = new Address();
			AddressDTO addressdto = dto.getAddressdto();
			BeanUtils.copyProperties(addressdto, add);
			add.setStudent(student);

		}
		return student;
	}

	public static StudentDTO map(Student student) {
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(student, dto);
		if (student.getAddress() != null) {
			Address address = student.getAddress();
			AddressDTO add = new AddressDTO();
			BeanUtils.copyProperties(address, add);
			add.setStudentdto(dto);

		}
		return dto;
	}

}
