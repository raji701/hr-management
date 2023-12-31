package com.hrmanagement.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrmanagement.portal.model.Employee;
import com.hrmanagement.portal.model.PersonalDetails.Gender;



public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	public Employee findByUserId( String id);
	
	public List<Employee> findAllByDepartmentId(int id);
	
	
	@Query("SELECT e FROM Employee e JOIN e.employeeSkillsList es JOIN es.skill s WHERE s.skillName = :skillName")
	List<Employee> findAllBySkillName(@Param("skillName") String skillName);

	
	@Query("SELECT e FROM Employee e JOIN e.personalDetails pd where pd.gender = :gender")
	List<Employee> findAllByGender(@Param ("gender") Gender gender );
	
	@Query("SELECT e.positionId from Employee e where e.employeeId = :employeeId")
	Integer positionOfTheEmployee(@Param("employeeId") Integer employeeId);
	
<<<<<<< HEAD
	@Query("SELECT e from Employee e where e.reportingTo = :employeeId")
	List<Employee> employeesUnder(@Param("employeeId") Integer employeeId);
	
	@Query("SELECT e from Employee e where e.positionId = :positionId and e.departmentId = :departmentId")
	List<Employee> employeesWithPosition(@Param("positionId") Integer positionId , @Param("departmentId") Integer departmentId );
=======
	@Query("SELECT e from Employee e where e.positionId = 8")
	List<Employee> employeesUnderManager();
>>>>>>> abbe14ff11cf9c3feb8937e9cc5d3c05104a3279
}
