package Listenser;

import bs_baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenserAction   extends Baseclass implements ITestListener{

    private ExtentTest test;
    public void onTestStart(ITestResult result) {
        System.out.println(".....onTestStart...... "+ result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);

    }
    public void onTestSuccess(ITestResult result)
    {
        System.out.println(".....onTestSuccess...... "+ result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
        extent.attachReporter(spark);
        test.log(Status.PASS, "Test Passed: "+result.getMethod().getMethodName());
        extent.flush();
    }


    public void onTestFailure(ITestResult result)
    {

        System.out.println(".....onTestFailure...... "+ result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
        extent.flush();
    }



    public void onTestSkipped(ITestResult result) {
        System.out.println(".....onTestSkipped...... "+ result.getName());
    }



}
