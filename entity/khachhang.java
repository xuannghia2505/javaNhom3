package entity;

public class khachhang {
	private Long makh;
	private String hoten;
	private String diachi;
	private String sodt;
	private String email;
	private String tendn;
	private String pass;
	private Long tienconlai;
	private boolean isAdmin;
	public khachhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public khachhang(Long makh, String hoten, String diachi, String sodt, String email, String tendn, String pass,Long tienconlai,boolean isAdmin) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
		this.tendn = tendn;
		this.pass = pass;
		this.tienconlai=tienconlai;
		this.isAdmin=isAdmin;
	}

	public Long getMakh() {
		return makh;
	}

	public void setMakh(Long makh) {
		this.makh = makh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTendn() {
		return tendn;
	}

	public void setTendn(String tendn) {
		this.tendn = tendn;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getTienconlai() {
		return tienconlai;
	}

	public void setTienconlai(Long tienconlai) {
		this.tienconlai = tienconlai;
	}
	public boolean getAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin =isAdmin;
	}
}
