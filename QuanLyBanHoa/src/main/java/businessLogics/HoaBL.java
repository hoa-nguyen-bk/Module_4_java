package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Hoa;

public class HoaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	public static List<Hoa> getHoas(){
		String sql = "SELECT * FROM Hoa";
		return jdbc.query(sql, new RowMapper<Hoa>() {
			@Override
			public Hoa mapRow(ResultSet rs, int numRow) throws SQLException {
				Hoa at = new Hoa();
				at.setTenHoa(rs.getString("tenhoa"));
				at.setMoTa(rs.getString("mota"));
				at.setHinh(rs.getString("hinh"));
				at.setMaHoa(rs.getInt("maHoa"));
				at.setDonGia(rs.getInt("dongia"));
				at.setMaLoai(rs.getInt("maloai"));
				return at;
			}
		});
	}
	public static void main(String[] args) {
		List<Hoa> hoa = getHoas();
		hoa.forEach(h->System.out.println(h.getTenHoa()));
	}
}
