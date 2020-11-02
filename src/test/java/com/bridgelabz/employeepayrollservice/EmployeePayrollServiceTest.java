package com.bridgelabz.employeepayrollservice;

import java.util.Arrays;

import org.junit.Test;

import com.bridgelabz.employeepayrollservice.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3Empoyee_WhenWrittenToFile_ShouldMatchingEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = {
			new EmployeePayrollData(1, " Jeff Bezos ", 100000.0),
			new EmployeePayrollData(2, " Bill Gates ", 200000.0),
			new EmployeePayrollData(1, " Mark Zuckerberg ", 300000.0)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
	}
}
