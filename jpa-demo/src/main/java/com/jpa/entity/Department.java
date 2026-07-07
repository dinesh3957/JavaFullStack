package com.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	@Id
	@Column(name = "dept_no")
	private int dept_no;
	@Column(name = "dname")
	private String deptname;
	private String location;

	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> emps = new ArrayList<Employee>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int dept_no, String deptname, String location) {
		super();
		this.dept_no = dept_no;
		this.deptname = deptname;
		this.location = location;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
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

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [dept_no=" + dept_no + ", deptname=" + deptname + ", location=" + location + "]";
	}

}
