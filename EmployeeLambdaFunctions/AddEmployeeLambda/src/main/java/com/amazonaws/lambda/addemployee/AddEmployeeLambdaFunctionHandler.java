package com.amazonaws.lambda.addemployee;


import com.amazonaws.employee.Employee;
import com.amazonaws.employee.EmployeeDatabase;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AddEmployeeLambdaFunctionHandler implements RequestHandler<Employee, String>{

	@Override
    public String handleRequest(Employee employee, Context context) {
        context.getLogger().log("employee details : " + employee.toString());
        
        EmployeeDatabase employeeDatabase = new EmployeeDatabase(context);
		
		String result = employeeDatabase.addEmployee("test", employee);
		
        context.getLogger().log("result : " + result);

        return result;
    }

}
