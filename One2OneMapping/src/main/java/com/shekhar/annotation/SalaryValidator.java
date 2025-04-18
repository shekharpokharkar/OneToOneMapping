package com.shekhar.annotation;

import java.math.BigDecimal;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SalaryValidator implements ConstraintValidator<SalaryValid, BigDecimal> {

	private long min;

	@Override
	public void initialize(SalaryValid constraintAnnotation) {
		this.min = constraintAnnotation.min(); // read the min from annotation
	}

	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		if (value == null) {
			return true; // or false depending on whether nulls should be allowed
		}

		return value.longValue() >= min;
	}
}
