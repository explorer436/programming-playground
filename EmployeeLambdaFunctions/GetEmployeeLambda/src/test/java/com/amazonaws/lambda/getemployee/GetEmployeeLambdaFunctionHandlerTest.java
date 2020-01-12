package com.amazonaws.lambda.getemployee;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.employee.Employee;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetEmployeeLambdaFunctionHandlerTest {

    private static String employeeId;

    @BeforeClass
    public static void createInput() throws IOException {
    	employeeId = "123456";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testGetEmployeeLambdaFunctionHandler() {
        GetEmployeeLambdaFunctionHandler handler = new GetEmployeeLambdaFunctionHandler();
        Context ctx = createContext();

        Employee employee = handler.handleRequest(employeeId, ctx);
        ctx.getLogger().log("employee : " + employee.toString());
        //Assert.assertEquals("Hello from Lambda!", output);
    }
}
