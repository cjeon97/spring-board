package main;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("config-main.xml");
		
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		String query = "select BANNER from v$version";
		String version = jdbcTemplate.queryForObject(query, String.class);
		System.out.println("version: " + version);
		
		ctx.close();
	}
}
