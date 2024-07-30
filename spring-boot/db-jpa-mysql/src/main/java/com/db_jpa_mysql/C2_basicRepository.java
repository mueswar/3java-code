package com.db_jpa_mysql;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/v1")
public class C2_basicRepository {
	@Autowired
	Remp re ;
	@Autowired
	Rdept rd ;

	@GetMapping(path="/fetch/emp")
	public Object fetchEmp() {
		var r = re.findAll();
		return r;
	}
	
	@GetMapping(path="/fetch/dept")
	public Object fetchDept() {
		var r = rd.findAll();
		return r;
	}
	
	@GetMapping(path="/save/{id}")
	public String save(@PathVariable int id) {
		Emp e = new Emp();
		re.save(e);
		return "saved...";
	}

}

@Repository
interface Remp extends JpaRepository<Emp, Integer>{
	
}

@Repository
interface Rdept extends JpaRepository<Dept, Integer>{
	
}

@Entity
@Table(name="EMPLOYEE")	
class Emp{
	@Id
	private int empcode;
	private String empfname;
	private String emplname;
	private String job;
	private String manager;
	private Date hiredate;
	private BigDecimal salary;
	private int commission;
	private Integer deptcode;
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpfname() {
		return empfname;
	}
	public void setEmpfname(String empfname) {
		this.empfname = empfname;
	}
	public String getEmplname() {
		return emplname;
	}
	public void setEmplname(String emplname) {
		this.emplname = emplname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public Integer getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(Integer deptcode) {
		this.deptcode = deptcode;
	}
	
}
@Entity
@Table(name="DEPARTMENT")	
class Dept{
	@Id
	private int deptcode;
	private String deptname;
	private String location;
	public int getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(int deptcode) {
		this.deptcode = deptcode;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}

