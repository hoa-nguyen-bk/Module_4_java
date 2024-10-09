package javaBeans;

import java.io.Serializable;

public class LoaiHoa implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maLoai;
    private String tenLoai;
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public LoaiHoa() {
		super();
	}
}
