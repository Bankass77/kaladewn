package ml.kalanblow.kaladewn.domain.user.web;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.service.SchoolService;

@Controller
@RequestMapping
public class SchoolController {

	private final SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@RequestMapping("/school")
	public ModelAndView getSchoolList() {

		Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name").descending());
		List<School> schools = schoolService.getAllSchoolList(sortedByName.toString(), sortedByName);

		ModelAndView modelAndView = new ModelAndView("school");
		modelAndView.addObject("schools", schools);

		return modelAndView;

	}

}
