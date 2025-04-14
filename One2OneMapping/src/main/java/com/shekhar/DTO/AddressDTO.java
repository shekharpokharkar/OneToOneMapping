package com.shekhar.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shekhar.entity.Student;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AddressDTO {

	private Long addressId;
	private String lane1;
	private String lane2;
	private String city;
	private String Country;
	private String zip;
	@Column(name = "student")
	private StudentDTO studentdto;
}
