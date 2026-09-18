package com.crm.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenersImplementationClass implements IRetryAnalyzer{
	
	int count = 0;
	int limitCount = 5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limitCount) {
			count++;
			return true;
		}
		count = 0;
		return false;
	}
}
