package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa() {
		List<LoaiSua> ds = new ArrayList<LoaiSua>();
		String sql = "SELECT * FROM loai_sua";
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				ds.add(ls);
			}
			return ds;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static LoaiSua docTheoMaLoai(String ml) {
		LoaiSua ls = null;
		String sql = "SELECT * FROM loai_sua WHERE ma_loai_sua = '"+ml+"'";
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				
			}
			return ls;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static LoaiSua docTheoMaLoai2(String ml) {
		//lọc trong list, lấy mã loại = với mã loại mình truyền, sau đó mới tách ra đối tượng
		return (LoaiSua) docTatCa().stream().filter(ls->ls.getMaLoai().equals(ml)).collect(Collectors.toList()).get(0);
	}
	
	public static int them(LoaiSua ls) {
		String sql = "INSERT INTO loai_sua(ma_loai_sua,ten_loai) VALUES (?,?)";
		try (Connection kn = CSDL.getKetNoi()){
			PreparedStatement pst = kn.prepareStatement(sql);
			pst.setString(1, ls.getMaLoai());
			pst.setString(2, ls.getTenLoai());
			return pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<LoaiSua> ds = docTatCa();
		ds.forEach(ls->System.out.println(ls.getTenLoai()));
	
		LoaiSua ls = docTheoMaLoai("SB");
		System.out.println(ls.getTenLoai());
		
		LoaiSua ls2 = docTheoMaLoai2("SB");
		System.out.println(ls2.getTenLoai());
		
		LoaiSua lsThem = new LoaiSua();
		lsThem.setMaLoai("aa");
		lsThem.setTenLoai("Sữa âa");
		them(lsThem);
	}

}
