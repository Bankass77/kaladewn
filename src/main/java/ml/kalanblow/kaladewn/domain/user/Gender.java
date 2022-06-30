package ml.kalanblow.kaladewn.domain.user;

public enum Gender {

	MALE('M'), FEMALE('F');

	private char c;

	Gender(char c) {
		this.c = c;

	}

	public char getGender() {
		return c;
	}
}
