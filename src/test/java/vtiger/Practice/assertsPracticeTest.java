package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertsPracticeTest {
	@Test
	public void assertPracticeTest()
	
	{
		System.out.println("====step1===");
		System.out.println("====Step2==");
		Assert.assertEquals("A","B");//hARD aSSERT
		System.out.println("====step1 Step2===");
		System.out.println("==== Step1,Step2,Step3=");
		
	}
	@Test
	public void assertPracticeTest1() {
		System.out.println("====step1===");
		System.out.println("====Step2==");
		SoftAssert sa=new SoftAssert();
		System.out.println("====Step1, step2==");
		sa.assertEquals(0, 1);
		System.out.println("====Step3==");
		System.out.println("====Step4==");
		sa.assertAll();
		
		
		
	}

}
