package entity;

public class cartOrder {
	private String maSP; 
	private String tenSP;
	private String img;
	private Long gia;
	private int soluongmua;
	private Long thanhtien;
	public cartOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartOrder(String maSP, String tenSP, String img, Long gia, int soluong) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.img = img;
		this.gia = gia;
		this.soluongmua = soluong;
		this.thanhtien=gia*soluong;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluongmua;
	}
	public void setSoluong(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
