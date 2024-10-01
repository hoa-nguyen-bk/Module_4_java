package businessLogic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL {
	private static JdbcTemplate jdbc;

	public static JdbcTemplate getJdbc() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");

		ds.setUrl("jdbc:mysql://localhost:3309/minishop_comem");
		ds.setUsername("root");
		ds.setPassword("");
		jdbc = new JdbcTemplate(ds);
		return jdbc;
	}

}
