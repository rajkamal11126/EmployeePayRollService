package com.bridgelabz.employeepayrollservice;

public class EmployeePayroll {
	private int id;
	private String name;
	private double salary;

	public EmployeePayroll(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return " id : " + this.id + " name : " + this.name + " salary : " + this.salary;
	}
}
