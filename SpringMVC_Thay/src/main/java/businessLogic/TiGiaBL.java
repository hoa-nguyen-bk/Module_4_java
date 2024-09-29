package businessLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javaBeans.TiGia;

public class TiGiaBL {
	public static List<TiGia> docTatCa() {
		List<TiGia> ds = new ArrayList<TiGia>();
		try {
			URL url = new URL("https://www.dongabank.com.vn/exchange/export");
			URLConnection uc = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String s = br.readLine();
			s = s.substring(1, s.length() - 1);
			System.out.println(s);
			JSONParser jsPar = new JSONParser();
			JSONObject jObj = (JSONObject) jsPar.parse(s);
			JSONArray jsArr = (JSONArray) jObj.get("items");
			for (int i = 0; i < jsArr.size(); i++) {
				JSONObject jsObj2 = (JSONObject) jsArr.get(i);
				TiGia tg = new TiGia();

				tg.setMaNgoaiTe(jsObj2.get("type").toString());

				tg.setCo(jsObj2.get("imageurl").toString());
				
				String t = (String) jsObj2.get("muatienmat");
				tg.setMuaTienMat(t.isEmpty() ? -1 : Float.parseFloat(t));
				
				t = (String) jsObj2.get("muack");
				tg.setMuaChuyenKhoang(t==null ? -1 : Float.parseFloat(t));
				
				t = (String) jsObj2.get("bantienmat");
				tg.setBanTM(t.isEmpty() ? -1 : Float.parseFloat(t));
				
				t = (String) jsObj2.get("banck");
				tg.setBanCK(t==null ? -1 : Float.parseFloat(t));
				
				ds.add(tg);
			}
			return ds;
		}catch (ParseException e) {

			e.printStackTrace();
			System.out.println("ParseException: " + e.getMessage());
			return null;
		}
		catch (IOException e) {

			e.printStackTrace();
			System.out.println("IOException: " + e.getMessage());
			return null;
		} catch (RuntimeException e) {

			e.printStackTrace();
			System.out.println("RuntimeException: " + e.getMessage());
			e.getMessage();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		List<TiGia> ds = docTatCa();
		if (ds.size() == 0) {
			System.out.println("empty");
		} else {
			ds.forEach(tg -> System.out.println(
					String.format("%s - %.2f - %.2f", tg.getMaNgoaiTe(), tg.getMuaTienMat(), tg.getMuaChuyenKhoang())));
		}
	}
}
