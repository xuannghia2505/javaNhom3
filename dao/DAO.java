package dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.w3c.dom.ls.LSOutput;

import context.DBcontext;
import entity.ChiTietHoaDon;
import entity.cartOrder;
import entity.hoadon;
import entity.khachhang;
import entity.lichsuruttien;
import entity.loaisach;
import entity.sach;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public ArrayList<sach> getAllsach() throws Exception{
		String query ="select * from sach";
		ArrayList<sach> listSach = new ArrayList<>();

		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			listSach.add(new sach(rs.getString(1), rs.getNString(2), rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),
					rs.getDate(8),rs.getString(9)));
		}
	
		return listSach;
	}
	public sach getSachbyMasach(String masach) throws Exception{
		String query ="select * from sach where masach=? ";
	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, masach);
		rs=ps.executeQuery();
		while(rs.next()) {
			return new sach(rs.getString(1), rs.getNString(2), rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),
					rs.getDate(8),rs.getString(9));
		}
		
		return null;
	}
	public ArrayList<sach> getSachbyMaloai(String maloai) throws Exception{
		String query ="select * from sach where maloai=? ";
		ArrayList<sach> sachs= new ArrayList<>();
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, maloai);
		rs=ps.executeQuery();
		while(rs.next()) {
			sachs.add(new sach(rs.getString(1), rs.getNString(2), rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),
					rs.getDate(8),rs.getString(9)));
		}
		
		return sachs;
	}
	
	public ArrayList<sach> getSachbyTensach(String tensach) throws Exception{
		String query ="select * from sach";
		ArrayList<sach> listSach= new ArrayList<>();
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(2).contains(tensach)){
			listSach.add(new sach(rs.getString(1), rs.getNString(2), rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),
					rs.getDate(8),rs.getString(9)));
			}
		}
		
		return listSach;
	}
	public ArrayList<sach> getSachbyIndex(int index) throws Exception{
		ArrayList<sach> listSach = new ArrayList<>();
		String query ="select * from (\r\n"
				+ "select ROW_NUMBER() OVER ( ORDER BY NgayNhap) AS [stt], *\r\n"
				+ "from sach\r\n"
				+ ") as bangSach\r\n"
				+ "where bangSach.stt between ? and ?";
	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setInt(1, (index-1)*6+1);
		ps.setInt(2, index*6);			
		rs=ps.executeQuery();
		while(rs.next()) {
			 listSach.add(new sach(rs.getString(2), rs.getNString(3), rs.getLong(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getDate(9),rs.getString(10)));
			}
		
		
		return listSach;
	}
	public int tongSach() throws Exception {
		int kq=0;
		String query = "select count(masach) from sach";
	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next())
				kq =rs.getInt(1);
		
		return kq;
	}
	public ArrayList<loaisach> getAllLoai() throws Exception{
		String query ="select * from loai";
		ArrayList<loaisach>	loaiSach = new ArrayList<>();
	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			loaiSach.add(new loaisach(rs.getString(1), rs.getNString(2)));
			}
		
		return loaiSach;
	}
	
	public khachhang getKH(String username,String pass) throws Exception{
	
		String query ="select * from KhachHang where tendn=? and pass=?";
		
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		while(rs.next()) {
			return new khachhang(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getLong(8),rs.getBoolean(9));
			}	
		return null;
	}
	public khachhang getKHbyUsername(String username) throws Exception{
		
		String query ="select * from KhachHang where tendn=?";
		
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while(rs.next()) {
			return new khachhang(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getLong(8),rs.getBoolean(9));
			}
		
		
		return null;
	}
	public khachhang getKHbyMakh(Long makh) throws Exception{
		
		String query ="select * from KhachHang where makh=?";
		
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		rs = ps.executeQuery();
		while(rs.next()) {
			return new khachhang(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getLong(8),rs.getBoolean(9));
			}
		
		return null;
	}
	public boolean insertDonhang(Long makh,String hoten,String sdt,String diachi) throws Exception {
		String query="insert into diachimoi values(?,?,?,?)";
		int tam=-1;
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ps.setString(2, hoten);
		ps.setString(3, sdt);
		ps.setString(4, diachi);
		tam= ps.executeUpdate();
		if(tam!=-1)
			return true;
		return false;
		
	}
	public boolean insertKhachHang(String hoten,String diachi,String sdt,String email,String username,String password) throws Exception {
		String query="insert into KhachHang values(?,?,?,?,?,?,0,0)";
		int tam=-1;
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setNString(1, hoten);
		ps.setNString(2, diachi);
		ps.setNString(3, '0'+sdt);
		ps.setNString(4, email);
		ps.setNString(5, username);
		ps.setNString(6, password);
		tam= ps.executeUpdate();
		if(tam!=-1)
			return true;
		return false;
		
	}
	public boolean insertDonHang(Long makh,ArrayList<cartOrder> cartOrders) throws Exception {
		String query="delete\r\n"
				+ "from ChiTietHoaDon\r\n"
				+ "where MaHoaDon in ( select MaHoaDon from hoadon where makh=? and damua=0) \r\n"
				+"DECLARE @MaHD bigint  \r\n"
				+ "insert into hoadon values (?,GETDATE(),1)\r\n"
				+ "SELECT @MaHD = SCOPE_IDENTITY()\r\n"
				+ "insert into ChiTietHoaDon values ";
		for(int i=0;i<cartOrders.size()-1;i++) {
			query+="(?,?,@MaHD,1),";
		}
		query+="(?,?,@MaHD,1)"; 
		int tam=-1;
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ps.setLong(2,makh);
		for(int i=0;i<cartOrders.size();i++) {
			ps.setNString(i*2+3,cartOrders.get(i).getMaSP());
			ps.setLong(i*2+4, cartOrders.get(i).getSoluong());		
		}
		tam= ps.executeUpdate();
		if(tam!=-1)
			return true;
		return false;
		
	}
	public boolean insertDonHangTam(Long makh,ArrayList<cartOrder> cartOrders) throws Exception {
		String query="delete \r\n"
				+ "from ChiTietHoaDon\r\n"
				+ "where MaHoaDon in (select MaHoaDon from hoadon where makh=? and damua=0)\r\n"
				+ "\r\n"
				+ "delete \r\n"
				+ "from hoadon\r\n"
				+ "where makh=? and damua=0 \r\n"
				+"DECLARE @MaHD bigint  \r\n"
				+ "insert into hoadon values (?,GETDATE(),0)\r\n"
				+ "SELECT @MaHD = SCOPE_IDENTITY()\r\n"
				+ "insert into ChiTietHoaDon values ";
		for(int i=0;i<cartOrders.size()-1;i++) {
			query+="(?,?,@MaHD,0),";
		}
		query+="(?,?,@MaHD,0)"; 
		int tam;
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ps.setLong(2, makh);
		ps.setLong(3, makh);
		for(int i=0;i<cartOrders.size();i++) {
			ps.setNString(i*2+4,cartOrders.get(i).getMaSP());
			ps.setLong(i*2+5, cartOrders.get(i).getSoluong());		
		}
		tam= ps.executeUpdate();
		if(tam!=1)
			return true;
		return false;
		
	}
	public ArrayList<cartOrder> getCartTam(Long makh) throws Exception{
		ArrayList<cartOrder> cartOrders = new ArrayList<>();
		String query ="select s.masach,s.tensach,s.anh,cthd.SoLuongMua,s.gia \r\n"
				+ "from ChiTietHoaDon as cthd join hoadon as hd on hd.MaHoaDon=cthd.MaHoaDon \r\n"
				+ "join sach as s on s.masach=cthd.MaSach\r\n"
				+ "where makh=? and cthd.damua=0";	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		rs =ps.executeQuery();
		while(rs.next()) {
				cartOrders.add(new cartOrder(rs.getString(1), rs.getString(2), rs.getString(3),rs.getLong(5),rs.getInt(4)));
			}
		
		return cartOrders;
	}
	public Long getTongtien(Long makh) throws Exception{
		long tongtien=0;
		String query ="select sum(s.gia*cthd.SoLuongMua)\r\n"
				+ "from ChiTietHoaDon as cthd join hoadon as hd on hd.MaHoaDon=cthd.MaHoaDon \r\n"
				+ "join sach as s on s.masach=cthd.MaSach\r\n"
				+ "where makh=? and cthd.damua=0\r\n"
				+ "group by cthd.damua";	
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		rs =ps.executeQuery();
		while(rs.next()) {
				tongtien= rs.getLong(1);
			}
		
		return tongtien;
	}
	public ArrayList<ChiTietHoaDon> getlsMuahangById(Long makh) throws Exception{
		String query ="select s.tensach,s.anh,cthd.SoLuongMua,hd.NgayMua,s.gia \r\n"
				+ "from ChiTietHoaDon as cthd join hoadon as hd on hd.MaHoaDon=cthd.MaHoaDon \r\n"
				+ "join sach as s on s.masach=cthd.MaSach\r\n"
				+ "where makh=? and cthd.damua=1";	
		ArrayList<ChiTietHoaDon> cthd= new ArrayList<>(); 
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		rs=ps.executeQuery();
		while(rs.next()) {
			cthd.add(new ChiTietHoaDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getLong(5)));
			}
		
		return cthd;
	}
	public void changeMoney(long tienconlai,Long makh) throws Exception{
		String query = "update KhachHang\r\n"
				+ "set tienconlai =? \r\n"
				+ "where makh=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, tienconlai);
		ps.setLong(2, makh);
		ps.executeUpdate();
	}
	public ArrayList<khachhang> getAllKhachhang() throws Exception{
		ArrayList<khachhang> listKhachhang = new ArrayList<>();
		String query = "select * from KhachHang";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			listKhachhang.add(new khachhang(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getLong(8),rs.getBoolean(9)));
		}
		return listKhachhang;
		
	}
	public boolean insertLsRutTien(Long makh,Long sotien) throws Exception{
		int tam;
		String query="insert into LichSuRutTien values(?,?,0)";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ps.setLong(2, sotien);
		tam= ps.executeUpdate();
		System.out.println(tam);
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public ArrayList<lichsuruttien> getLsruttien() throws Exception {
		ArrayList<lichsuruttien> listLS = new ArrayList<>();
		String query = "select ls.maLs,ls.makh,nh.stk,nh.tentk,ls.sotienrut\r\n"
				+ "from LichSuRutTien  as ls join NganHang as nh on nh.makh=ls.makh\r\n"
				+ "where trangthai=0";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			listLS.add(new lichsuruttien(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getLong(5)));
		}
		return listLS;
	}
	
	public boolean updateTrangthaiLS(Long maLs) throws Exception{
		int tam;
		String query="update LichSuRutTien\r\n"
				+ "set trangthai=1\r\n"
				+ "where maLs=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, maLs);
		tam= ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	
	public ArrayList<lichsuruttien> getLsruttienbyMakh(Long makh) throws Exception {
		ArrayList<lichsuruttien> listLS = new ArrayList<>();
		String query = "select ls.maLs,ls.makh,nh.stk,nh.tentk,ls.sotienrut\r\n"
				+ "from LichSuRutTien  as ls join NganHang as nh on nh.makh=ls.makh\r\n"
				+ "where trangthai=0 and ls.makh=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		rs = ps.executeQuery();
		while(rs.next()) {
			listLS.add(new lichsuruttien(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getLong(5)));
		}
		return listLS;
	}
	
	public boolean updateKhachhang(String hoten,String diachi,String sdt,String email,String pass,Long tienconlai, Boolean admin,Long makh) throws Exception{
		String query="update KhachHang\r\n"
				+ "set hoten=?, diachi=?, sodt=?, email=?,pass=?,tienconlai=?,isAdmin=?\r\n"
				+ "where makh=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setNString(1, hoten);
		ps.setNString(2, diachi);
		ps.setNString(3, sdt);
		ps.setNString(4, email);
		ps.setNString(5, pass);
		ps.setLong(6, tienconlai);
		ps.setBoolean(7, admin);
		ps.setLong(8, makh);
		int tam=ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public boolean deleteUser(Long makh) throws Exception{
		int tam;
		String query="delete from KhachHang\r\n"
				+ "where makh=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		tam= ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public boolean updateSach(String tensach,Long soluong,Long gia,String maloai,String sotap,String anh,String tacgia,String masach) throws Exception{
		String query="update sach\r\n"
				+ "set tensach=?,soluong=?,gia=?,maloai=?,sotap=?,anh=?,tacgia=?\r\n"
				+ "where masach=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setNString(1, tensach);
		ps.setLong(2, soluong);
		ps.setLong(3, gia);
		ps.setNString(4, maloai);
		ps.setNString(5, sotap);
		ps.setNString(6, anh);
		ps.setNString(7, tacgia);
		ps.setNString(8, masach);
		int tam=ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public boolean deleteSach(String masach) throws Exception{
		int tam;
		String query="delete from sach\r\n"
				+ "where masach=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, masach);
		tam= ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public boolean insertSach(String masach,String tensach,Long soluong,Long gia,String maloai,String sotap,String anh,String tacgia) throws Exception{
		String query="insert into sach values(?,?,?,?,(select maloai from loai where maloai=?),?,?,GETDATE(),?)";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setNString(1, masach);
		ps.setNString(2, tensach);
		ps.setLong(3, soluong);
		ps.setLong(4, gia);
		ps.setNString(5, maloai);
		ps.setNString(6, sotap);
		ps.setNString(7, anh);
		ps.setNString(8, tacgia);
		int tam=ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
	}
	public ArrayList<hoadon> getAllhoadon() throws Exception{
		String query="select hd.MaHoaDon,hd.makh,hd.NgayMua \r\n"
				+ "from hoadon as hd \r\n"
				+ "where hd.MaHoaDon not in (select maHoaDon from GiaoHang ) and hd.damua=1";
		ArrayList<hoadon> hoadons= new ArrayList<>();
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			hoadons.add(new hoadon(rs.getLong(1),rs.getLong(2),rs.getDate(3)));
		}
		return hoadons;
	}
	public boolean insertGiaohang(Long mahoadon) throws Exception{
		String query="insert into GiaoHang values(?,1)";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, mahoadon);
		int tam=ps.executeUpdate();
		if(tam!=1) {
			return false;
		}
		return true;
		
	}
	public ArrayList<sach> getCTHDbyMaHD(Long mahd) throws Exception{
		ArrayList<sach> sachs = new ArrayList<>();
		String query="select *\r\n"
				+ "from sach as s join ChiTietHoaDon as cthd on cthd.MaSach=s.masach\r\n"
				+ "where cthd.MaHoaDon=?";
		conn = new DBcontext().getConnection();
		ps = conn.prepareStatement(query);
		ps.setLong(1, mahd);
		rs=ps.executeQuery();
		while(rs.next()) {
			sachs.add(new sach(rs.getString(1), rs.getNString(2), rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),
					rs.getDate(8),rs.getString(9)));
		}
		return sachs;
	}
	
}
