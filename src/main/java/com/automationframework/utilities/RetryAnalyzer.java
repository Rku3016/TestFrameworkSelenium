package com.automationframework.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount=0; //no of retries
    private static final int maxRetryCount = 2; // max no of retries
    @Override
    public boolean retry(ITestResult result) {
        if(retryCount<maxRetryCount){
            retryCount++;
            System.out.println("Retrying " + result.getName() + " | Retry attempt " + retryCount);
            return  true;
        }
        return false;
    }
}
