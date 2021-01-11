package szbd.licensemanagementsystemapp.customerserviceusers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import szbd.licensemanagementsystemapp.employees.Employee;
import szbd.licensemanagementsystemapp.users.User;

@Entity
@Table(name = "customer_service_user")
public class CustomerServiceUser {
	@Id
    @Column(name = "ID")
    private Long id;
	private float salesTargetValue;
	private int salesTargetLicenses;
	@OneToOne
    @MapsId
    @JoinColumn(name = "ID")
    private Employee employee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}