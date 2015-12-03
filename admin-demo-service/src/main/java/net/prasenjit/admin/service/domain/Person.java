package net.prasenjit.admin.service.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Person {
	@NotNull
	private Integer id;
	private String firstname;
	@NotEmpty
	private String lastname;
}
