package com.amazonaws.lambda.deleteemployee;

import com.amazonaws.employee.Employee;
import com.amazonaws.services.lambda.runtime.Context;

public class DeleteEmployeeLambdaFunctionHandler{

    public String handleRequest(Employee employee, Context context) {
    	context.getLogger().log("employee details : " + employee.toString());

    	return "success";
    }

}
