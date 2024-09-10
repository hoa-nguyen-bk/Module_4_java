package businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class CSDL {
	private static Connection ketNoi;
	private static final String url = "jdbc:mysql://localhost:3309/ql_bansua";
	public static Connection getKetNoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ketNoi = DriverManager.getConnection(url,"root","");
			return ketNoi;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection kn = getKetNoi();
		if(kn!=null) {
			System.out.println("thanh cong");
		} else {
			System.out.println("thatbai");
		}
	}

}
