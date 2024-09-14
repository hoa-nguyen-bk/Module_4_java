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
	public static Author getAuthor(int id) {
		String sql = "SELECT * FROM author WHERE authorid = ?";
		// đối số id
		return (Author) jdbc.queryForObject(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author at = new Author();
				at.setAuthorId(rs.getInt("authorid"));
				at.setAuthorName(rs.getString("authorname"));
				return at;
			}
		}, id);
	}
	public static int add(Author at) {
		String sql = "INSERT INTO author(authorname) value (?)";
		return jdbc.update(sql, at.getAuthorName());
	}
	public static int edit(Author at) {
		String sql = "UPDATE author SET authorname = ? WHERE authorid = ?";
		return jdbc.update(sql,at.getAuthorName(),at.getAuthorId());
	}
	public static int del(int id) {
		String sql = "DELETE FROM author WHERE authorid = ?";
		return jdbc.update(sql,id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Author> la = getAuthors();
//		la.forEach(at -> System.out.println(at.getAuthorId()+" - "+at.getAuthorName()));
	
//		get author 
//		Author at = getAuthor(2);
//		System.out.println(at.getAuthorId()+" - "+ at.getAuthorName());
	
//		thêm author
//		Author at = new Author();
//		at.setAuthorName("aaa");
//		System.out.println(add(at));
	
//		sửa author
//		Author auSua = getAuthor(107);
//		auSua.setAuthorName("bb");
//		System.out.println(edit(auSua));
		
//		xóa author
		System.out.println(del(107));
	}

}
