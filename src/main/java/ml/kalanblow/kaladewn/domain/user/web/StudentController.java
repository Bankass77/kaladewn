package ml.kalanblow.kaladewn.domain.user.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ml.kalanblow.kaladewn.domain.user.CreateStudentFormData;
import ml.kalanblow.kaladewn.domain.user.EditeMode;
import ml.kalanblow.kaladewn.domain.user.EditStudentFormData;
import ml.kalanblow.kaladewn.domain.user.Gender;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.exception.EntityType;
import ml.kalanblow.kaladewn.exception.ExceptionType;
import ml.kalanblow.kaladewn.exception.KaladewnManagementException;
import ml.kalanblow.kaladewn.service.StudentService;
import ml.kalanblow.kaladewn.validation.ValidationGroupSequence;

@Controller
@RequestMapping("/student")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;

	}

	@GetMapping("/all")
	public String getAllStudent(Model model, @SortDefault.SortDefaults({ @SortDefault("userName.lastName"),
			@SortDefault("userName.firstName") }) Pageable pageable) {

		model.addAttribute("users", studentService.getUsers(pageable));

		return "users/student/list";
	}

	@GetMapping("/create")
	public String addNewStudent(Model model) {
		model.addAttribute("user", new CreateStudentFormData());
		model.addAttribute("genders", List.of(Gender.FEMALE, Gender.MALE));
		model.addAttribute("editeMode", EditeMode.CREATE);
		return "users/student/edit";
	}

	@PostMapping("/create")
	public String createStudent(Model model,
			@Validated(ValidationGroupSequence.class) @ModelAttribute("user") CreateStudentFormData formData,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("genders", List.of(Gender.FEMALE, Gender.MALE));
			return "users/student/edit";
		}

		studentService.createStudent(formData.toParameters());

		return "redirect:/users/student/list";

	}

	@GetMapping("/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long id, Model model) {

		var student = studentService.getUser(id).orElseThrow(() -> new KaladewnManagementException()
				.throwException(EntityType.STUDENT, ExceptionType.ENTITY_NOT_FOUND, String.valueOf(id)));

		model.addAttribute("user", EditStudentFormData.fromStudent((Student) student));
		model.addAttribute("genders", List.of(Gender.FEMALE, Gender.MALE));
		model.addAttribute("editeMode", EditeMode.UPDATE);
		return "users/student/edit";

	}

	@PostMapping("/edit/{id}")
	public String doEditStudent(@PathVariable("id") Long id,
			@Validated(ValidationGroupSequence.class) @ModelAttribute("user") EditStudentFormData formData,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("genders", List.of(Gender.FEMALE, Gender.MALE));
			model.addAttribute("editeMode", EditeMode.UPDATE);

			return "users/student/edit";
		}

		studentService.editStudent(id, formData.toParameters());

		return "redirect:/users/student/edit";

	}

	@DeleteMapping("/delete/{id}")
	public String doDeleteStudentById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

		studentService.delete(id);
		redirectAttributes.addFlashAttribute("detlete student id");
		return "redirect:/users/student/list";

	}
}
