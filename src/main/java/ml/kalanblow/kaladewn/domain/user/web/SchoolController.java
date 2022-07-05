package ml.kalanblow.kaladewn.domain.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ml.kalanblow.kaladewn.service.SchoolService;

@Controller
@RequestMapping("/school")
public class SchoolController {

	private final SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	

}
