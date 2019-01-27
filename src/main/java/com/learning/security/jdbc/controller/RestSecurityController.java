package com.learning.security.jdbc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSecurityController {

	@GetMapping("/techLead")
	@Secured("ROLE_TECH_LEAD")
	public String securedByTechLead() {
		return "Hey, you are having Tech Lead role!!!";
	}

	@GetMapping("/admin")
	@Secured("ROLE_ADMIN")
	public String securedByAdmin() {
		return "Hey, you are having Admin role!!!";
	}

	@GetMapping("/employee")
	@Secured("ROLE_EMPLOYEE")
	public String securedByEmployee() {
		return "Hey, you are having Employee role!!!";
	}
}
