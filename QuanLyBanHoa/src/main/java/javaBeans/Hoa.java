package javaBeans;

import java.io.Serializable;

public class Hoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maHoa;
	private int maLoai;
	private String tenHoa;
	private int donGia;
	private String hinh;
	private String moTa;
	public Hoa() {
		super();
	}
	public int getMaHoa() {
		return maHoa;
	}
	public void setMaHoa(int maHoa) {
		this.maHoa = maHoa;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenHoa() {
		return tenHoa;
	}
	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
