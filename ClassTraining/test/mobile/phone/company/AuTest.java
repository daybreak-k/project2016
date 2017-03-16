package mobile.phone.company;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuTest {
	
	@Test
	public void testCalc() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "SE";
		Au.time = 10;
		int result = au.calc();
		assertEquals(result, 1550);
	}

	@Test
	public void testDisplay() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "SE";
		Au.time = 10;
		au.display();
	}
	
	@Test
	public void testCalcDiscountSchool() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "学生";
		Au.time = 10;
		int result = au.calc();
		assertEquals(result, 1050);
	}
	
	@Test
	public void testDisplayDiscountSchool() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "学生";
		Au.time = 10;
		au.display();
	}
	
	@Test
	public void testCalcDiscountHigh() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "高校生";
		Au.time = 10;
		int result = au.calc();
		assertEquals(result, 1050);
	}
	
	@Test
	public void testDisplayDiscountHigh() {
		final Au au = new Au();
		Au.name = "ishii";
		Au.age = 21;
		Au.job = "高校生";
		Au.time = 10;
		au.display();
	}
	

}
