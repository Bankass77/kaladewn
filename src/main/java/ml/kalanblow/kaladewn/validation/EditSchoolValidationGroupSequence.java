package ml.kalanblow.kaladewn.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class})
public interface EditSchoolValidationGroupSequence {

}