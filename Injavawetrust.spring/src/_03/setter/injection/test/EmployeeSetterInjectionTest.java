package _03.setter.injection.test;

import org.springframework.context.support.GenericXmlApplicationContext;
import _03.setter.injection.model.Employee;

public class EmployeeSetterInjectionTest {

	public static void main(String[] args) {

		// Instead of DefaultListableBeanFactory, an instance of
		// GenericXmlApplicationContext is instantiated.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:03.appcontext.setter.injection.xml");
		ctx.refresh();

		Employee employee = ctx.getBean("empId", Employee.class);
		Employee employee2 = ctx.getBean("empId2", Employee.class);
		System.out.println(employee);
		System.out.println(employee2);

		ctx.close();
	}
}
