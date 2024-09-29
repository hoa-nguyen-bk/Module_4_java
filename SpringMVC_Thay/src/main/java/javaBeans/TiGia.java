package javaBeans;

import java.io.Serializable;

public class TiGia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNgoaiTe;
	private String co; // cờ
	private float muaTienMat;
	private float muaChuyenKhoang;
	private float banTM;
	private float banCK;
	public TiGia() {
		super();
	}
	public String getMaNgoaiTe() {
		return maNgoaiTe;
	}
	public void setMaNgoaiTe(String maNgoaiTe) {
		this.maNgoaiTe = maNgoaiTe;
	}
	public String getCo() {
		return co;
	}
	public void setCo(String co) {
		this.co = co;
	}
	public float getMuaTienMat() {
		return muaTienMat;
	}
	public void setMuaTienMat(float muaTienMat) {
		this.muaTienMat = muaTienMat;
	}
	public float getMuaChuyenKhoang() {
		return muaChuyenKhoang;
	}
	public void setMuaChuyenKhoang(float muaChuyenKhoang) {
		this.muaChuyenKhoang = muaChuyenKhoang;
	}
	public float getBanTM() {
		return banTM;
	}
	public void setBanTM(float banTM) {
		this.banTM = banTM;
	}
	public float getBanCK() {
		return banCK;
	}
	public void setBanCK(float banCK) {
		this.banCK = banCK;
	}

	
}
