package com.form.validation.formvalidation.controller

import com.form.validation.formvalidation.model.Customer
import jakarta.validation.Valid
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CustomerController {

	@InitBinder
	public fun initBinder(dataBinder: WebDataBinder) {
		val strippedString = StringTrimmerEditor(true)

		dataBinder.registerCustomEditor(String::class.java, strippedString)
	}

	@GetMapping("/")
	public fun showForm(model: Model): String {
		model.addAttribute("customer", Customer())

		return "customer-form"
	}

	@PostMapping("/processForm")
	public fun processForm(
		@Valid @ModelAttribute("customer") customer: Customer, bindingResult: BindingResult
	): String {
		return if (bindingResult.hasErrors()) "customer-form" else "customer-confirmation"
	}
}