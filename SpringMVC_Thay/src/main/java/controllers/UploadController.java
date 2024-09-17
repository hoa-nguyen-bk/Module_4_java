package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
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
			model.addAttribute("tapTin",tapTin); // sử dụng model để đặt dữ liệu lên trên đó để quay trở về
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "upload-file-tiles";
	}
	
	// giờ upload nhiều file
	@RequestMapping(path="/upload-multiple-file")
	public String uploadMultipleFile() {
		return "multi-upload";
	}
	
	@RequestMapping(path = "/upload-multiple-file", method = RequestMethod.POST)
	public String uploadMultipleFile( @RequestParam(name="file") MultipartFile[] parts, HttpServletRequest request, Model model) {
		String path = request.getServletContext().getRealPath("/upload/");
		try {
			model.addAttribute("list",upload(path,parts));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "multi-upload";
	}

	private static List<String> upload(String path, MultipartFile[] parts) {
		List<String> files = new ArrayList<String>(parts.length);
		for(MultipartFile part:parts) {
			String file = upload(path, parts);
			files.addAll(file);
		}
		return files;
	}
}
