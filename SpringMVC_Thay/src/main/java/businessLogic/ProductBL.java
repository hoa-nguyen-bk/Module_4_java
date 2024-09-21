package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Product;

public class ProductBL {
	private static JdbcTemplate  jdbc = CSDL2.getJdbc();
	private static int SODONGTRANG = 6;
	public static List<Product> getAll(){
		String sql = "SELECT * FROM product";
		return jdbc.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int numRow) throws SQLException {
				Product p = new Product();
				p.setProductId(rs.getInt("productid"));
				p.setCategoryId(rs.getInt("categoryid"));
				p.setPublisherId(rs.getInt("publisherid"));
				p.setAuthorId(rs.getInt("authorid"));
				p.setIsbn(rs.getString("isbn"));
				p.setTitle(rs.getString("title"));
				p.setPages(rs.getInt("pages"));
				p.setYear(rs.getInt("year"));
				p.setWeight(rs.getString("weight"));
				p.setSize(rs.getString("size"));
				p.setDescription(rs.getString("description"));
				p.setContent(rs.getString("content"));
				p.setImageUrl(rs.getString("imageurl"));
				p.setPrice(rs.getInt("price"));
				return p;
			}
		});
	}
	public static Product getProduct(int productId){
		String sql = "SELECT * FROM product WHERE productid = ?";
		return jdbc.queryForObject(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int numRow) throws SQLException {
				Product p = new Product();
				p.setProductId(rs.getInt("productid"));
				p.setCategoryId(rs.getInt("categoryid"));
				p.setPublisherId(rs.getInt("publisherid"));
				p.setAuthorId(rs.getInt("authorid"));
				p.setIsbn(rs.getString("isbn"));
				p.setTitle(rs.getString("title"));
				p.setPages(rs.getInt("pages"));
				p.setYear(rs.getInt("year"));
				p.setWeight(rs.getString("weight"));
				p.setSize(rs.getString("size"));
				p.setDescription(rs.getString("description"));
				p.setContent(rs.getString("content"));
				p.setImageUrl(rs.getString("imageurl"));
				p.setPrice(rs.getInt("price"));
				return p;
			}
		}, productId);
	}
	public static int tongSoTrang() {
		String sql = "SELECT count(*) as tsd from product";
		int tongSoDong = jdbc.queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int numRow) throws SQLException {
				return rs.getInt("tsd");
			}
		});
		int tongSoTrang = tongSoDong/SODONGTRANG + (tongSoDong%SODONGTRANG !=0?1:0);
		return tongSoTrang;
	}

	public static List<Product> productTheoTrangSo(int trang){
		List<Product> l = getAll();
		int vt = (trang - 1)*SODONGTRANG;
		//Trang đầu tiên là 1: 0 -> 5 | 6 -> 10
		return l.stream().skip(vt).limit(SODONGTRANG).toList();
	}
	public static List<Product> productTheoCategoryId(int categoryId){
		List<Product> l = getAll();
		return l.stream().filter(p->p.getCategoryId()==categoryId).toList();
	}
	
	public static void main(String[] args) {
//		List<Product> ds = getAll();
//		ds.forEach(p->System.out.println(p.getTitle()));
//		int tst = tongSoTrang();
//		System.out.println("tong so trang la: "+ tst);
//		List<Product> ds = productTheoTrangSo(3);
//		List<Product> ds = productTheoCategoryId(9);
//		ds.forEach(p->System.out.println(p.getTitle()));
//		Product p = getProduct(1);
//		System.out.println(p.getTitle());
		
	}
}
