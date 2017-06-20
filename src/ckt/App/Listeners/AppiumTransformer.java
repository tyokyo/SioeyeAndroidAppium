package ckt.App.Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AppiumTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		if ("verify".equals(testMethod.getName())) {  
			annotation.setInvocationCount(15);  
		}  
		
	}  
}  