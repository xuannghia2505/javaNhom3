package entity;

import java.sql.Date;

public class hoadon {
	private long mahoadon;
	private long makh;
	private Date ngaymua;
	public hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadon(long mahoadon, long makh, Date ngaymua) {
		super();
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.ngaymua = ngaymua;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	
}
