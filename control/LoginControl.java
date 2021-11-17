package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DAO;
import entity.cartOrder;
import entity.khachhang;
import entity.loaisach;
import entity.sach;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			DAO dao = new DAO();
			ArrayList<sach> listSach = dao.getAllsach();
			ArrayList<loaisach> loaiSach;
			loaiSach = dao.getAllLoai();
			request.setAttribute("listSHome", listSach);
			request.setAttribute("loaiSach", loaiSach);
			request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			DAO dao = new DAO();		
			String makh = request.getParameter("txtuser");
			String pass = request.getParameter("txtpass");
	 		khachhang kh = dao.getKH(makh,pass);
	 			
	 		if(kh!=null) {
	 			if(kh.getAdmin()==true) {
		 			
		 			session.setAttribute("kh", kh);
		 			session.setMaxInactiveInterval(6000);
		 			response.sendRedirect("quantriUser");
		 		}else {
	 			long tongtien = 0;
	 			tongtien= dao.getTongtien(kh.getMakh());
	 			ArrayList<cartOrder> cartOrders = new ArrayList<>();
	 			cartOrders=dao.getCartTam(kh.getMakh());
	 			session.setAttribute("listCart", cartOrders);
	 			session.setAttribute("tongtien", tongtien);
	 			session.setAttribute("kh", kh);
	 	 		session.setMaxInactiveInterval(6000);
	 	 		
	 	 		//du lieu trang chu
	 	 		ArrayList<sach> listSach = dao.getAllsach();
				ArrayList<loaisach> loaiSach = dao.getAllLoai();
				request.setAttribute("listSHome", listSach);
				request.setAttribute("loaiSach", loaiSach);
				request.getRequestDispatcher("trangchu.jsp").forward(request, response);	
		 		}
	 			
	 		}else { 			
	 		//du lieu trang chu
			
			ArrayList<sach> listSach = dao.getAllsach();
			ArrayList<loaisach> loaiSach = dao.getAllLoai();
			request.setAttribute("listSHome", listSach);
			request.setAttribute("loaiSach", loaiSach);
			request.getRequestDispatcher("trangchu.jsp").forward(request, response);	
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
