package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Author;

public class AuthorBL {
	private static JdbcTemplate jdbc = CSDL2.getJdbc();
	public static List<Author> getAuthors(){
		String sql = "SELECT * FROM author";
		return jdbc.query(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author at = new Author();
				at.setAuthorId(rs.getInt("authorid"));
				at.setAuthorName(rs.getString("authorname"));
				return at;
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Author> la = getAuthors();
		la.forEach(at -> System.out.println(at.getAuthorId()+" - "+at.getAuthorName()));
	}

}
