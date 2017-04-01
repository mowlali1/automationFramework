package com.oracle.tr.test.buyProduct;

import org.testng.annotations.BeforeMethod;

public class TestPDF {
	
	/*
	@BeforeMethod(alwaysRun = true)
    public void testData(Method method, Object[] testData) {
        String testCase = "";
        if (testData != null && testData.length > 0) {
            TestParameters testParams = null;
            String _dyna_name = null;
            //Check if test method has actually received required parameters
            for (Object testParameter : testData) {
                if (testParameter instanceof TestParameters) {
                    testParams = (TestParameters) testParameter;
                    break;
                }
                if (testParameter instanceof String) {
                    _dyna_name = (String) testParameter;
                    break;
                }
            }
            if (testParams != null) {
                testCase = testParams.getTestName();
            }
            if(_dyna_name!=null){
                testCase = _dyna_name;
            }
        }
        this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
    }
*/
}
