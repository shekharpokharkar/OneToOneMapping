package com.shekhar.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shekhar.annotation.SalaryValid;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
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
public class StudentDTO {

	private Long studentId;
	private String studentNane;
	private Double studentPercentage;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate studentDateOfBirth;
	@SalaryValid(min = 5000)
	private BigDecimal studentSalary;
	@JsonProperty("maritialStatus")
	private Boolean isMarried;
	private Character studentGender;
	@JsonProperty("address")
	private AddressDTO addressdto;
}
