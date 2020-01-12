package com.amazonaws.lambda.getemployees;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.employee.Employee;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetEmployeesLambdaFunctionHandlerTest {

    private static Object input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = "test";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testGetEmployeesLambdaFunctionHandler() {
        GetEmployeesLambdaFunctionHandler handler = new GetEmployeesLambdaFunctionHandler();
        Context ctx = createContext();

//        List<Employee> output = handler.handleRequest(input, ctx);
//        
//        for(Employee em : output)
//        {
//        	ctx.getLogger().log("employee : " + em.toString());
//        }
        

        // TODO: validate output here if needed.
        //Assert.assertEquals("Hello from Lambda!", output);
    }
}
