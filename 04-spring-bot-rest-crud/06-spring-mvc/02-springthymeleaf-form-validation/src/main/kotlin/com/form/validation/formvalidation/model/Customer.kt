package com.form.validation.formvalidation.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

class Customer {
	var firstName: String? = ""

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	var lastName: String? = ""

	override fun toString(): String {
		return "Customer(firstName='$firstName', lastName='$lastName')"
	}
}
