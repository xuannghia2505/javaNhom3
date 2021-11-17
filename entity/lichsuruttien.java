package entity;

public class lichsuruttien {
	private long mals;
	private long makh;
	private String stk;
	private String tentk;
	private long sotienrut;
	public lichsuruttien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsuruttien(long mals, long makh, String stk, String tentk, long sotienrut) {
		super();
		this.mals = mals;
		this.makh = makh;
		this.stk = stk;
		this.tentk = tentk;
		this.sotienrut = sotienrut;
	}
	public long getMals() {
		return mals;
	}
	public void setMals(long mals) {
		this.mals = mals;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getStk() {
		return stk;
	}
	public void setStk(String stk) {
		this.stk = stk;
	}
	public String getTentk() {
		return tentk;
	}
	public void setTentk(String tentk) {
		this.tentk = tentk;
	}
	public long getSotienrut() {
		return sotienrut;
	}
	public void setSotienrut(long sotienrut) {
		this.sotienrut = sotienrut;
	}
	
	
	
}
