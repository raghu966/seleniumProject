package com.automation.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int maxRetryCount = 2;

	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			if (count < maxRetryCount) {
				count++;
				return true;
			}
		}
		return false;
	}
}
