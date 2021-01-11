package szbd.licensemanagementsystemapp.customerserviceusers;

import java.time.LocalDate;

public class CustomerServiceUserDto {
	
	private Long userid;
	 private String nickname;
	 private String email;
	 private String firstname;
	 private String surname;  
	 private String role;
	 private boolean enabled;
	 private LocalDate employmentDate;
	private String position;
	private String departmentName;
	private float basicSalary;
	private int workingHours;
	private float salesTargetValue;
	private int salesTargetLicenses;
	
	public CustomerServiceUserDto(Long userid, String nickname, String email, String firstname, String surname,
			String role, boolean enabled, LocalDate employmentDate, String position, String departmentName,
			float basicSalary, int workingHours, float salesTargetValue, int salesTargetLicenses) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.role = role;
		this.enabled = enabled;
		this.employmentDate = employmentDate;
		this.position = position;
		this.departmentName = departmentName;
		this.basicSalary = basicSalary;
		this.workingHours = workingHours;
		this.salesTargetValue = salesTargetValue;
		this.salesTargetLicenses = salesTargetLicenses;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getEmploymentdate() {
		return employmentDate;
	}

	public void setEmploymentdate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartmentname() {
		return departmentName;
	}

	public void setDepartmentname(String departmentName) {
		this.departmentName = departmentName;
	}

	public float getBasicsalary() {
		return basicSalary;
	}

	public void setBasicsalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getWorkinghours() {
		return workingHours;
	}

	public void setWorkinghours(int workingHours) {
		this.workingHours = workingHours;
	}

	public float getSalestargetvalue() {
		return salesTargetValue;
	}

	public void setSalestargetvalue(float salesTargetValue) {
		this.salesTargetValue = salesTargetValue;
	}

	public int getSalestargetlicenses() {
		return salesTargetLicenses;
	}

	public void setSalestargetlicenses(int salesTargetLicenses) {
		this.salesTargetLicenses = salesTargetLicenses;
	}	
	
	
	
	
	
	
	
}
