package com.shekhar.utils;

import org.springframework.beans.BeanUtils;

import com.shekhar.DTO.AddressDTO;
import com.shekhar.DTO.StudentDTO;
import com.shekhar.entity.Address;
import com.shekhar.entity.Student;

public interface AddressUtils {

	public static Address map(AddressDTO DTO) {
		Address address = new Address();
		BeanUtils.copyProperties(DTO, address);

		if (DTO.getStudentdto() != null) {
			Student student = new Student();
			StudentDTO studentdto = DTO.getStudentdto();
			BeanUtils.copyProperties(studentdto, student);
			address.setStudent(student);
		}
		return address;
	}

	public static AddressDTO map(Address address) {
		AddressDTO dto = new AddressDTO();
		BeanUtils.copyProperties(address, dto);
		if (address.getStudent() != null) {
			Student student = address.getStudent();
			StudentDTO studto = new StudentDTO();
			BeanUtils.copyProperties(student, studto);
			dto.setStudentdto(studto);

		}
		return dto;
	}

}
