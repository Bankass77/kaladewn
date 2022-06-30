package ml.kalanblow.kaladewn.domain.user.web;

import org.springframework.stereotype.Controller;

import ml.kalanblow.kaladewn.service.SchoolService;

@Controller
public class SchoolController {
	
	
	private final SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	

}
