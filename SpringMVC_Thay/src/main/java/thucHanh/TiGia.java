package thucHanh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TiGia {
	public static void main(String[] arg) throws IOException {
		// https://duythanhcse.wordpress.com/2018/10/16/nhung-api-ti-gia-hoi-doai-cua-ngan-hang-dong-a-vao-website-rieng-asp-net-core/
		URL url = new URL("https://www.dongabank.com.vn/exchange/export");
		URLConnection uc = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String s = br.readLine();
		s = s.substring(1, s.length() - 1);
		System.out.println(s);
	}
}