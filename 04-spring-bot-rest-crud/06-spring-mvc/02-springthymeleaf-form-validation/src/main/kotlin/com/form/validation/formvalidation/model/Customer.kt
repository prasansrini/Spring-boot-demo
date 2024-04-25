package com.form.validation.formvalidation.model

import jakarta.validation.constraints.*

class Customer {
	var firstName: String? = ""

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	var lastName: String? = ""

	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than zero")
	@Max(value = 10, message = "must be lesser than ten")
	var freePasses: Int? = null

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits allowed")
	var postalCode: String? = null

	override fun toString(): String {
		return "Customer(firstName=$firstName, lastName=$lastName, freePasses=$freePasses, postalCode=$postalCode)"
	}
}
