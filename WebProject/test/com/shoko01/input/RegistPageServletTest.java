package com.shoko01.input;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RegistPageServletTest {

	@Test
	public void testDoExec() {
		final RegistPageServlet registPageServlet = new RegistPageServlet();
		
		final StringBuffer result = new StringBuffer();
		
		final Map<String, String> map = new HashMap<String, String>();
		map.put("name", "ISHII");
		map.put("age", "21");
		map.put("sex", "1");
		map.put("zip_code", "null");
		
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Method method = RegistPageServlet.class.getDeclaredMethod("doExec", Map.class, StringBuffer.class, Statement.class);
			method.setAccessible(true);
			final StringBuffer actual = (StringBuffer) method.invoke(registPageServlet, map, new StringBuffer(), statement);
			
			assertEquals(result.toString(), actual.toString());
		} catch(Exception e) {
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
