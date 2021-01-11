package szbd.licensemanagementsystemapp.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DepartmentRepository  extends JpaRepository<Department, Long> {
	
	  @Query("SELECT d FROM Department d WHERE d.name = :name")
	    public Department getDepartmentByName(@Param("name") String name);

}
