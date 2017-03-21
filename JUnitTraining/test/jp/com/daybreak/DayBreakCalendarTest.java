package jp.com.daybreak;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DayBreakCalendarTest {

	@Test
	public void testExecution() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final String result = calendar.execution("201703");
		System.out.println(result);

		StringBuffer actual = new StringBuffer();
		actual.append("2017年03月");
		actual.append(System.lineSeparator());
		actual.append("日 月 火 水 木 金 土");
		actual.append(System.lineSeparator());
		actual.append("--------------------");
		actual.append(System.lineSeparator());
		actual.append("         01 02 03 04");
		actual.append(System.lineSeparator());
		actual.append("05 06 07 08 09 10 11");
		actual.append(System.lineSeparator());
		actual.append("12 13 14 15 16 17 18");
		actual.append(System.lineSeparator());
		actual.append("19 20 21 22 23 24 25");
		actual.append(System.lineSeparator());
		actual.append("26 27 28 29 30 31 ");

		assertEquals(result, actual.toString());
	}
	
	@Test
	public void testExecutionLeapYear2016() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final String result = calendar.execution("201602");
		System.out.println(result);

		StringBuffer actual = new StringBuffer();
		actual.append("2016年02月");
		actual.append(System.lineSeparator());
		actual.append("日 月 火 水 木 金 土");
		actual.append(System.lineSeparator());
		actual.append("--------------------");
		actual.append(System.lineSeparator());
		actual.append("   01 02 03 04 05 06");
		actual.append(System.lineSeparator());
		actual.append("07 08 09 10 11 12 13");
		actual.append(System.lineSeparator());
		actual.append("14 15 16 17 18 19 20");
		actual.append(System.lineSeparator());
		actual.append("21 22 23 24 25 26 27");
		actual.append(System.lineSeparator());
		actual.append("28 29 ");

		assertEquals(result, actual.toString());
	}
	
	@Test
	public void testExecutionLeapYear2000() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final String result = calendar.execution("200002");
		System.out.println(result);

		StringBuffer actual = new StringBuffer();
		actual.append("2000年02月");
		actual.append(System.lineSeparator());
		actual.append("日 月 火 水 木 金 土");
		actual.append(System.lineSeparator());
		actual.append("--------------------");
		actual.append(System.lineSeparator());
		actual.append("      01 02 03 04 05");
		actual.append(System.lineSeparator());
		actual.append("06 07 08 09 10 11 12");
		actual.append(System.lineSeparator());
		actual.append("13 14 15 16 17 18 19");
		actual.append(System.lineSeparator());
		actual.append("20 21 22 23 24 25 26");
		actual.append(System.lineSeparator());
		actual.append("27 28 29 ");

		assertEquals(result, actual.toString());
	}
	
	@Test
	public void testExecutionNotLeapYear() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final String result = calendar.execution("210002");
		System.out.println(result);

		StringBuffer actual = new StringBuffer();
		actual.append("2100年02月");
		actual.append(System.lineSeparator());
		actual.append("日 月 火 水 木 金 土");
		actual.append(System.lineSeparator());
		actual.append("--------------------");
		actual.append(System.lineSeparator());
		actual.append("   01 02 03 04 05 06");
		actual.append(System.lineSeparator());
		actual.append("07 08 09 10 11 12 13");
		actual.append(System.lineSeparator());
		actual.append("14 15 16 17 18 19 20");
		actual.append(System.lineSeparator());
		actual.append("21 22 23 24 25 26 27");
		actual.append(System.lineSeparator());
		actual.append("28 ");

		assertEquals(result, actual.toString());
	}
	
	@Test
	public void testGetFirstDate() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date result = format.parse("20170301");
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getFirstDate", String.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, "201703");
		
		System.out.println("月初日");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetLastDate() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20170315");
		final Date result = format.parse("20170331");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getLastDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("月末日(通常)");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetLastDateLeapYear2016() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20160215");
		final Date result = format.parse("20160229");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getLastDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("月末日(普通の閏年)");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetLastDateLeapYear2000() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20000215");
		final Date result = format.parse("20000229");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getLastDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("月末日(400年に一度の閏年)");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetLastDateNotLeapYear() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("21000215");
		final Date result = format.parse("21000228");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getLastDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("月末日(100年周期の普通の年)");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetDayOfWeek() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20170301");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getDayOfWeek", Calendar.class, Date.class);
		method.setAccessible(true);
		int acutual = (int) method.invoke(calendar, cal, date);
		
		assertEquals(4, acutual);
	}
	
	@Test
	public void testAddDate() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20170228");
		final Date result = format.parse("20170301");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("addDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("普通の翌日");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testAddDateLeapYear2016() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20160228");
		final Date result = format.parse("20160229");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("addDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("閏年の翌日");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testAddDateLeapYear2000() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20000228");
		final Date result = format.parse("20000229");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("addDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("400年に一度の閏年の翌日");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testAddDateNotLeapYear() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("21000228");
		final Date result = format.parse("21000301");
		final Calendar cal = Calendar.getInstance();
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("addDate", Calendar.class, Date.class);
		method.setAccessible(true);
		Date acutual = (Date) method.invoke(calendar, cal, date);
		
		System.out.println("100年周期の普通の翌日");
		System.out.println(result.toString());
		System.out.println(acutual.toString());
		
		assertEquals(result, acutual);
	}
	
	@Test
	public void testGetDateString() throws Exception {
		final DayBreakCalendar calendar = new DayBreakCalendar();
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final Date date = format.parse("20170301");
		final String result = "01";
		final Calendar cal = Calendar.getInstance();
		
		
		Method method = DayBreakCalendar.class.getDeclaredMethod("getDateString", Calendar.class, Date.class);
		method.setAccessible(true);
		String acutual = (String) method.invoke(calendar, cal, date);
		
		System.out.println(result);
		System.out.println(acutual);
		
		assertEquals(result, acutual);
	}
	

}
