package entity;

import java.sql.Date;

public class ChiTietHoaDon {
	private String tenSach;
	private String imageSach;
	private int soluongMua;
	private Date ngaymua;
	private Long gia;
	private Long thanhtien;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(String tenSach, String imageSach, int soluongMua, Date ngaymua, Long gia) {
		super();
		this.tenSach = tenSach;
		this.imageSach = imageSach;
		this.soluongMua = soluongMua;
		this.ngaymua = ngaymua;
		this.gia = gia;
		this.thanhtien = gia*soluongMua;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getImageSach() {
		return imageSach;
	}
	public void setImageSach(String imageSach) {
		this.imageSach = imageSach;
	}
	public int getSoluongMua() {
		return soluongMua;
	}
	public void setSoluongMua(int soluongMua) {
		this.soluongMua = soluongMua;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
}
