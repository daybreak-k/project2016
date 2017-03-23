package com.shoko01.input;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Map;

import org.junit.Test;

public class InputPageServletTest {

	@Test
	public void testDoExec() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final InputPageServlet inputPageServlet = new InputPageServlet();
		final StringBuffer result = new StringBuffer();
		result.append("<form action=\"regist.jsp\" method=\"get\">");
		result.append("<table boder=\"2\">");
		result.append("<tr>");
		result.append("<td>名前</td>");
		result.append("<td><input name=\"name\" type=\"text\" value=\"\" maxlength=\"128\"></td>");
		result.append("</tr>");

		result.append("<tr>");
		result.append("<td>年齢</td>");
		result.append("<td><input name=\"age\" type=\"text\" value=\"\" maxlength=\"128\"></td>");
		result.append("</tr>");

		result.append("<tr>");
		result.append("<td>性別</td>");
		result.append("<td><select name=\"sex\"><option value=\"1\">男性</option><option value=\"2\">女性</option></select></td>");
		result.append("</tr>");

		result.append("<tr>");
		result.append("<td>郵便番号</td>");
		result.append("<td><input name=\"zip_code\" type=\"text\" value=\"\" maxlength=\"128\"></td>");
		result.append("</tr>");
		result.append("</table>");

		result.append("<input type=\"submit\" value=\"送信\">");
		result.append("<input type=\"reset\" value=\"リセット\">");

		result.append("</form>");
		
		Method method = InputPageServlet.class.getDeclaredMethod("doExec", Map.class, StringBuffer.class, Statement.class);
		method.setAccessible(true);
		final StringBuffer actual = (StringBuffer) method.invoke(inputPageServlet, null, new StringBuffer(), null);
		
		assertEquals(result.toString(), actual.toString());
	}

}
