package com.my.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ClasspathXmlAppContextTestDriver
{
    public static void main(String a[]){
        System.out.println( "Hello World!" );

        String confFile = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(confFile);
        SampleBean sampleBean = (SampleBean) context.getBean("springFirstTest");
        sampleBean.methodInSampleBean();
    }
}
