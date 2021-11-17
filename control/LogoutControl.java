package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.cartOrder;
import entity.khachhang;
import entity.loaisach;
import entity.sach;

/**
 * Servlet implementation class LogoutControl
 */
@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				//acc
				HttpSession session = request.getSession();
				khachhang kh = (khachhang) session.getAttribute("kh");
				
				//du lieu trang chu
				DAO dao = new DAO();
				ArrayList<sach> listSach = dao.getAllsach();
				ArrayList<loaisach> loaiSach = dao.getAllLoai();
				ArrayList<cartOrder> cartOrders = new ArrayList<>();
				cartOrders = (ArrayList<cartOrder>) session.getAttribute("listCart");
				if(cartOrders!=null) {		
					if(cartOrders.size()>0) {				
						dao.insertDonHangTam(kh.getMakh(), cartOrders);
						session.removeAttribute("tongtien");
						session.removeAttribute("listCart");
						
					}
				}
				session.removeAttribute("kh");
				
//				request.setAttribute("listSHome", listSach);
//				request.setAttribute("loaiSach", loaiSach);
				
				
				response.sendRedirect("loadTrangchu");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
