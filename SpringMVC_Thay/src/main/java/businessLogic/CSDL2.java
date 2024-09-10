package businessLogic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL2 {
	private static JdbcTemplate jdbc;
	public static JdbcTemplate getJdbc() {
		//b1: nạp trình điều khiển
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//b2: tạo chuỗi kết nối
		ds.setUrl("jdbc:mysql://localhost:3309/bai4_minishop");
		ds.setUsername("root");
		ds.setPassword("");
		jdbc = new JdbcTemplate(ds);
		return jdbc;
	}
	
}
