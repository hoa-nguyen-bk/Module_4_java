package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	// khi click vào đây người ta sẽ gọi cái này, này là ánh xạ xử lý
	@RequestMapping(path = "/upload-file")
	public String uploadFile() {
		return "upload-file-tiles"; // trả về cái tên định nghĩa trong tiles
	}

	// bây giờ phải tìm cách đưa được file lên server
	@RequestMapping(path = "/upload-file", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(name = "file") MultipartFile part, HttpServletRequest request, Model model) {
		// tại cái đối tượng request mới lấy đc địa chỉ thực
		String tapTin, thuMuc;
		tapTin = part.getOriginalFilename();
		thuMuc = request.getServletContext().getRealPath("/img/");
		try {
			byte[] mb = part.getBytes();
			FileOutputStream fos = new FileOutputStream(thuMuc + tapTin);
			fos.write(mb);
			fos.close();// đóng tập tin
			model.addAttribute("tapTin", tapTin); // sử dụng model để đặt dữ liệu lên trên đó để quay trở về
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "upload-file-tiles";
	}

	// giờ upload nhiều file
	@RequestMapping(path = "/upload-multiple-file")
	public String uploadMultipleFile() {
		return "multi-upload";
	}

	@RequestMapping(path = "/upload-multiple-file", method = RequestMethod.POST)
	public String uploadMultipleFile(@RequestParam(name = "files") MultipartFile[] parts, HttpServletRequest request,
			Model model) {
		String tm = request.getServletContext().getRealPath("/img/");
		String tt;
		List<String> dsTapTin = new ArrayList<String>();
		for (MultipartFile part : parts) {
			tt = part.getOriginalFilename();
//			cho nó xuất ra cái tập tin luôn 
			try (OutputStream os = new FileOutputStream(tm + tt)) {
//			thông qua đối tượng part ta lấy được mảng byte luôn
				byte[] mb = part.getBytes();
				os.write(mb);
				dsTapTin.add(tt);
//				xong nó tự động close luôn 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("dsTapTin", dsTapTin);
		return "multi-upload";
	}

}
