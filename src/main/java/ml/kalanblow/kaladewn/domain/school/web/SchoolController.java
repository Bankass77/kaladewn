package ml.kalanblow.kaladewn.domain.school.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ml.kalanblow.kaladewn.domain.school.CreateSchoolFormData;
import ml.kalanblow.kaladewn.domain.school.EditSchoolFormData;
import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.EditMode;
import ml.kalanblow.kaladewn.service.SchoolService;
import ml.kalanblow.kaladewn.service.StudentService;

@Controller
@RequestMapping("/school")
public class SchoolController {

	private final SchoolService schoolService;
	private final StudentService studentService;

	public SchoolController(SchoolService schoolService, StudentService studentService) {
		super();
		this.schoolService = schoolService;
		this.studentService = studentService;
	}

	// tag::doCreateTeam[]
	@GetMapping("/create")
	public ModelAndView createSchool() {

		ModelAndView modelAndView = new ModelAndView("/school/editSchool");

		modelAndView.addObject("school", new CreateSchoolFormData());
		return modelAndView;

	}

	// tag::doCreateTeam[]
	@PostMapping("/create")
	public ModelAndView doCreateScholl(@Valid @ModelAttribute("school") CreateSchoolFormData formData,
			BindingResult bindingResult, ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {

			modelAndView.addObject("editMode", EditMode.CREATE);

			return new ModelAndView("school/editSchool");
		}

		schoolService.createNewSchool(formData.toParameters());
		return modelAndView;

	}

	// tag::getSchoolList[]
	@GetMapping("/all")
	public ModelAndView getSchoolList(@SortDefault.SortDefaults(@SortDefault("name")) Pageable pageable) {

		ModelAndView modelAndView = new ModelAndView("schoool/schoolList");
		modelAndView.addObject("schools", schoolService.getAllSchoolList(pageable));

		return modelAndView;

	}

	// tag::editSchoolForm[]
	@GetMapping("/{id}")
	public ModelAndView editSchoolForm(@PathVariable("id") Long id, ModelAndView modelAndView) {

		School school = schoolService.getSchool(id).get();
		modelAndView.addObject("editSchool", EditSchoolFormData.fromSchool(school));
		modelAndView.addObject("editMode", EditMode.UPDATE);

		return new ModelAndView("school/editSchool");
	}

	// tag::doEditSchool[]
	@PostMapping("/{id}")
	public ModelAndView doEditSchool(@PathVariable("id") Long id,
			@Valid @ModelAttribute("school") EditSchoolFormData formData, BindingResult bindingResult,
			ModelAndView modelAndView) {

		Optional<School> school = schoolService.getSchool(id);

		if (bindingResult.hasErrors()) {

			modelAndView.addObject("editMode", EditMode.UPDATE);

			return new ModelAndView("school/editSchool");
		}

		schoolService.editSchool(school.get().getSchoolId(), formData.toParameters());

		return new ModelAndView("redirect:/schoool/schoolList");

	}

	// tag::doDeleteSchool[]
	@PostMapping("/{id}/delete")
	public ModelAndView doDeleteSchool(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

		Optional<School> school = schoolService.getSchool(id);
		redirectAttributes.addFlashAttribute("deleteSchoolName", school.get().getName());

		return new ModelAndView("redirect:/schoool/schoolList");
	}
}
