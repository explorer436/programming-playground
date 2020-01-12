package com.amazonaws.lambda.deleteemployee;

import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.employee.Employee;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class DeleteEmployeeLambdaFunctionHandlerTest {

	private static Employee employee;

    @BeforeClass
    public static void createInput() throws IOException {
    	employee = new Employee();
    	
    	employee.setId("123456");
		employee.setFirstName("John");
		employee.setLastName("Doe");
		employee.setAge(30);
		employee.setGender("male");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testDeleteEmployeeLambdaFunctionHandler() {
        DeleteEmployeeLambdaFunctionHandler handler = new DeleteEmployeeLambdaFunctionHandler();
        Context ctx = createContext();

        String output = handler.handleRequest(employee, ctx);

		Assert.assertEquals("success", output);
    }
}
