package com.amazonaws.lambda.getemployees;

import java.util.List;
import com.amazonaws.employee.Employee;
import com.amazonaws.employee.EmployeeDatabase;
import com.amazonaws.services.lambda.runtime.Context;

public class GetEmployeesLambdaFunctionHandler {

	public List<Employee> handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);

		EmployeeDatabase employeeDatabase = new EmployeeDatabase(context);
		
		List<Employee> result = employeeDatabase.getEmployees();

		return result;
	}

}
