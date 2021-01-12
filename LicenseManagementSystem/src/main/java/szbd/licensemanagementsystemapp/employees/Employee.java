package szbd.licensemanagementsystemapp.employees;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import szbd.licensemanagementsystemapp.customers.Customer;
import szbd.licensemanagementsystemapp.customerserviceusers.CustomerServiceUser;
import szbd.licensemanagementsystemapp.department.Department;
import szbd.licensemanagementsystemapp.users.User;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
    @Column(name = "ID")
    private Long id;
	private LocalDate employmentDate;
	private String position;
	private float basicSalary;
	private int workingHours;
	@OneToOne
    @MapsId
    @JoinColumn(name = "ID")
    private User user;
	 @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn
	private CustomerServiceUser customerServiceUser;	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "department_id", nullable = false)
	 private Department department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public CustomerServiceUser getCustomerservicesser() {
		return customerServiceUser;
	}
	public void setCustomerserviceuser(CustomerServiceUser customerServiceUser) {
		this.customerServiceUser = customerServiceUser;
	}
	
	
	
}
