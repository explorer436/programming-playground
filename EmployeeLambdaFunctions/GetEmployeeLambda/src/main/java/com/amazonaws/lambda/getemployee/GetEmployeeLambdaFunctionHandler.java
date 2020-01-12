package com.amazonaws.lambda.getemployee;

import com.amazonaws.employee.Employee;
import com.amazonaws.employee.EmployeeDatabase;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetEmployeeLambdaFunctionHandler  implements RequestHandler<String, Employee>{

    public Employee handleRequest(String employeeId, Context context) {
        context.getLogger().log("employeeId : " + employeeId);

        EmployeeDatabase employeeDatabase = new EmployeeDatabase(context);        
        
        Employee resultEmployee = employeeDatabase.getEmployeeById(employeeId);
		try 
		{
			context.getLogger().log("resultEmployee : " + resultEmployee.toString());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultEmployee;
    }

}
