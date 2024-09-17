package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Category;

public class CategoryBL {
	private static JdbcTemplate jdbc = CSDL2.getJdbc();
	public static List<Category> getParents(){
		//lấy các category mà ko có cha
		String sql = "SELECT * FROM `category` WHERE ParentId is null";
		return jdbc.query(sql, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				Category c = new Category();
				c.setCategoryId(rs.getInt("categoryid"));
				c.setCategoryName(rs.getString("categoryname"));
				c.setParentId(rs.getInt("parentid"));
				return c;
			}
		});
	}
	public static void main(String[] args) {
		List<Category> ds;
		ds = getParents();
		ds.forEach(c->System.out.println(c.getCategoryName()));
	}
}
