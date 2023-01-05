package com.listeners;

import com.api.Report.ExtentManagerLogging;
import com.api.Report.ExtentReport;
import com.api.annotations.FrameworkAnnotation;
import org.testng.*;

public class TestListeners implements ITestListener ,ISuiteListener {


    public void onStart(ISuite suite) {
        ExtentReport.init_reports();
    }

    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }


    public void onTestStart(ITestResult result) {
        ExtentReport.create_Report(result.getName());
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors();
        ExtentReport.addAuthor(authors);

        String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
        ExtentReport.addCategory(categories);

        String[] devices = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).device();
        ExtentReport.addDevice(devices);
    }


    public void onTestSuccess(ITestResult result) {
        ExtentManagerLogging.passed(result.getName() + "passed");

    }

    public void onTestFailure(ITestResult result) {
        ExtentManagerLogging.failed(String.valueOf(result.getThrowable()));
    }

    public void onTestSkipped(ITestResult result) {
    }


    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

}