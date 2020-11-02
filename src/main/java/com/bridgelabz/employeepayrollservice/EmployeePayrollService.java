package com.bridgelabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, REST_IO
	}

	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner scan = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(scan);
		employeePayrollService.writeEmployeePayrollData(null);
	}

	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(EmployeePayrollService.IOService ioService) {
		if (ioService.equals(EmployeePayRollService.IOService.CONSOLE_IO))
			System.out.println("\n Writing employee pay roll to console \n " + employeePayrollList);
		else if (ioService.equals(EmployeePayRollService.IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
	}

	@Override
	public String toString() {
		return "Writing employee pay roll " + "employeePayrollList=" + employeePayrollList + '}';
	}
}
