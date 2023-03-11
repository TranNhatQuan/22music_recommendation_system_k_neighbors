package web.bean;

public class matHang {
	private String tenMatHang;
	private int maMatHang;
	private int soLuong;
	private int donGia;
	
	public matHang() {
	this.tenMatHang = "";
	this.maMatHang = 0;
	this.soLuong = 0;
	this.donGia = 0;
	}
	
	public matHang(String tenMatHang, int maMatHang, int soLuong, int donGia) {
	
		this.tenMatHang = tenMatHang;
		this.maMatHang = maMatHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public int getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(int maMatHang) {
		this.maMatHang = maMatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int doanhThu() {
		return this.donGia*this.soLuong;
	}
	
}
