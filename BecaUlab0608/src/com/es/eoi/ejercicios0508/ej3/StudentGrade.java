package com.es.eoi.ejercicios0508.ej3;

public class StudentGrade implements Comparable<StudentGrade> {

	public enum Grade {

		INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE, MH;

	}

	// ATRIBUTES

	private String name;
	private Integer grade;
	private Grade textGrade;

	// {GET, SET}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Grade getTextGrade() {
		return textGrade;
	}

	// CONSTRUCTORS

	public StudentGrade() {

	}

	public StudentGrade(String name, Integer grade) {
		this.name = name;
		this.grade = grade;

		textGrade();

	}

	public StudentGrade(String name, Integer grade, Grade textGrade) {
		this.name = name;
		this.grade = grade;
		this.textGrade = textGrade;
	}

	// METHODS

	public void textGrade() {

		if (getGrade() < 5) {
			textGrade = Grade.INSUFICIENTE;

		} else if (getGrade() >= 5 && getGrade() < 6) {
			textGrade = Grade.SUFICIENTE;

		} else if (getGrade() >= 6 && getGrade() < 8) {
			textGrade = Grade.BIEN;

		} else if (getGrade() >= 8 && getGrade() < 10) {
			textGrade = Grade.SOBRESALIENTE;

		} else if (getGrade() == 10) {
			textGrade = Grade.MH;

		}

	}

	public String gradeAsString(Grade g) {

		switch (g) {
		case INSUFICIENTE:

			return "INSUFICIENTE";

		case SUFICIENTE:

			return "SUFICIENTE";

		case BIEN:

			return "BIEN";

		case NOTABLE:

			return "NOTABLE";
			
		case SOBRESALIENTE:
			
			return "SOBRESALIENTE";

		case MH:

			return "MH";

		default:

			return null;
		}

	}

	@Override
	public int compareTo(StudentGrade student) {

		if (this.getGrade() == student.getGrade()) {
			return 0;
		} else if (this.getGrade() > student.getGrade()) {
			return 1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		return (gradeAsString(getTextGrade()) + "(" + getGrade().toString() + ") " + getName());
	}

}
