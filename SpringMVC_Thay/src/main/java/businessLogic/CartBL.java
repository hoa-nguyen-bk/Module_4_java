package businessLogic;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Cart;

public class CartBL {
	private static JdbcTemplate jdbc;
	public static List<Cart> getCarts(String id){
		String sql = "CALL GetCarts(?)";
		return jdbc.query(sql, new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) {
				Cart cart = new Cart();
				return cart;
			}
		}, id)
	}
}
