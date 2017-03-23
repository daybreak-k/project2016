package com.shoko01.input;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

import org.junit.Test;

public class ReferPageServletTest {

	@Test
	public void testDoExec() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final ReferPageServlet referPageServlet = new ReferPageServlet();
		final StringBuffer result = new StringBuffer();
		result.append("<table border=\"2\">");
		result.append("<tr>");
		result.append(String.format("<td>%s</td>", "レコード番号"));
		result.append(String.format("<td>%s</td>", "ID"));
		result.append(String.format("<td>%s</td>", "名前"));
		result.append(String.format("<td>%s</td>", "年齢"));
		result.append(String.format("<td>%s</td>", "性別"));
		result.append(String.format("<td>%s</td>", "郵便番号"));
		result.append("</tr>");
		
		result.append("<tr>");
		result.append("<td>0</td>");
		result.append("<td>1</td>");
		result.append("<td>YAMADA</td>");
		result.append("<td>25</td>");
		result.append("<td>1</td>");
		result.append("<td>null</td>");
		result.append("</tr>");
		
		result.append("<tr>");
		result.append("<td>1</td>");
		result.append("<td>2</td>");
		result.append("<td>KIKUCHI</td>");
		result.append("<td>28</td>");
		result.append("<td>1</td>");
		result.append("<td>null</td>");
		result.append("</tr>");
		
		result.append("<tr>");
		result.append("<td>2</td>");
		result.append("<td>3</td>");
		result.append("<td>AOKI</td>");
		result.append("<td>31</td>");
		result.append("<td>2</td>");
		result.append("<td>null</td>");
		result.append("</tr>");
		
		result.append("<tr>");
		result.append("<td>3</td>");
		result.append("<td>4</td>");
		result.append("<td>SAKAMOTO</td>");
		result.append("<td>29</td>");
		result.append("<td>1</td>");
		result.append("<td>null</td>");
		result.append("</tr>");
		
		result.append("<tr>");
		result.append("<td>4</td>");
		result.append("<td>5</td>");
		result.append("<td>NAKATA</td>");
		result.append("<td>27</td>");
		result.append("<td>1</td>");
		result.append("<td>110-0003</td>");
		result.append("</tr>");
		
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Method method = ReferPageServlet.class.getDeclaredMethod("doExec", Map.class, StringBuffer.class, Statement.class);
			method.setAccessible(true);
			final StringBuffer actual = (StringBuffer) method.invoke(referPageServlet, null, new StringBuffer(), statement);
			
			assertEquals(result.toString(), actual.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (final Throwable e) {
				throw new RuntimeException(e);
			}
		}
	}

}
