package com.assignment.model;

/**
 * @author Rajeev.Loghade Entity class : Employee
 */
public class Employee {

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private Address address;
	private String dob;
	private String company;
	private Manager managerId;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String password, String mobile, Address address,
			String dob, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.company = company;
	}

	public Employee(String firstName, String lastName, String email, String password, String mobile, Address address,
			String dob, String company, Manager managerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.company = company;
		this.managerId = managerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + ", address=" + address + ", dob=" + dob
				+ ", company=" + company + ", managerId=" + managerId + "]";
	}

}
