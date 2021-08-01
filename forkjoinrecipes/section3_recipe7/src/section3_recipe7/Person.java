package section3_recipe7;

import java.util.Date;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int salary;
	private double coeficient;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
