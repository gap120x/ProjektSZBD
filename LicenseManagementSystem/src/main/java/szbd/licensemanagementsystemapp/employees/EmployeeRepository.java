package szbd.licensemanagementsystemapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import szbd.licensemanagementsystemapp.users.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
