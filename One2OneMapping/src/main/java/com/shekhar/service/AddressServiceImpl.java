package com.shekhar.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.shekhar.DTO.AddressDTO;
import com.shekhar.DTO.StudentDTO;
import com.shekhar.entity.Address;
import com.shekhar.entity.Student;
import com.shekhar.repository.AddressRepository;
import com.shekhar.repository.StudentRepository;
import com.shekhar.utils.AddressUtils;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public AddressDTO partialUpdateAddress(Long addressId, Map<String, Object> addressInfo) {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new RuntimeException("Address Not Found"));

		addressInfo.forEach((key, value) -> {

			Field field = ReflectionUtils.findField(Address.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, address, value);

		});

		Address address2 = addressRepository.save(address);

		return AddressUtils.map(address2);

	}

	@Override
	public AddressDTO deleteAddressById(Long addressId) {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new RuntimeException("Address Not Found"));
		addressRepository.delete(address);
		return AddressUtils.map(address);

	}

	@Override
	public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new RuntimeException("Address not found"));

		BeanUtils.copyProperties(addressDTO, address);

		if (addressDTO.getStudentdto() != null) {
			Student stu = new Student();
			StudentDTO studentdto = addressDTO.getStudentdto();
			BeanUtils.copyProperties(studentdto, stu);
			address.setStudent(stu);
		}

		address.setAddressId(addressId);
		Address address2 = addressRepository.save(address);
		AddressDTO addressDTO2 = AddressUtils.map(address2);
		return addressDTO2;
	}

	@Override
	public AddressDTO getAddressById(Long addressId) {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new RuntimeException("Address not found"));

		return AddressUtils.map(address);

	}

	@Override
	public List<AddressDTO> getAllAddress() {

		return addressRepository.findAll().stream().map(AddressUtils::map).toList();

	}

	@Override
	public AddressDTO saveAddress(Long studentId, AddressDTO addressDTO) {

		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found Exception"));
		Address address = new Address();
		BeanUtils.copyProperties(addressDTO, address);

		address.setStudent(student);

		Address address2 = addressRepository.save(address);
		return AddressUtils.map(address2);

	}

}
