package businessLogic;

import org.springframework.jdbc.core.JdbcTemplate;

import javaBeans.Member;
import util.Helper;

public class MemberBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();

	public static int add(Member obj) {
		obj.setId(Helper.randomLong());
		int a = jdbc.update(
				"INSERT INTO Member(MemberId, Username, Password, Email, Gender, Tel, Address) VALUES(?, ?, ?, ?, ?, ?, ?)",
				obj.getId(), obj.getUsername(), Helper.bcrypt(obj.getPassword()), obj.getEmail(), obj.isGender(),
				obj.getTel(), obj.getAddress());
		int b = jdbc.update("INSERT INTO MemberInRole(MemberId, RoleId) VALUES(?, ?)", obj.getId(), 1);
		return a + b;
	}

	public static void main(String[] args) {
		Member m = new Member();
		m.setPassword("123a");
		m.setGender(false);
		m.setAddress("123 hasha");
		m.setEmail("a@g.com");
		m.setTel("012");
		m.setUsername("hoa2");
		System.out.println(add(m));
	}
}
