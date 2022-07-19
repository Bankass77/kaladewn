package ml.kalanblow.kaladewn.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditStudentFormData  extends CreateStudentFormData {
	
	public static EditStudentFormData fromStudent(Student student) {
		
		
		EditStudentFormData result= new EditStudentFormData();

		return result;
		
	}

}
