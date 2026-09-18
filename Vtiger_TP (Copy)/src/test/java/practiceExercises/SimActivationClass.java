package practiceExercises;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SimActivationClass {
	@Test(retryAnalyzer = com.crm.Listeners.RetryListenersImplementationClass.class)
	public void activateSim() {
		Assert.assertEquals("hello", "hii");
		
	}
}
