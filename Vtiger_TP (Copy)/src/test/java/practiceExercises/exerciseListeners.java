package practiceExercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;


public class exerciseListeners extends BaseClass{
	@Test
	public void exerciseTest1() throws Exception
	{
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		Assert.assertEquals("hello", "hii");   //produces assertErrorException
		System.out.println("step 3 ");
		System.out.println("step 4 ");	
	}
	
	@Test
	public void exerciseTest2() throws Exception
	{
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		Assert.assertEquals("hello", "hello");   //runs properly
		System.out.println("step 3 ");
		System.out.println("step 4 ");	
	}
}
