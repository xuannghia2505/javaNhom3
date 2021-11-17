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
import entity.sach;

/**
 * Servlet implementation class dathangControl
 */
@WebServlet("/dathangControl")
public class dathangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public dathangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			long tongtien = (long) session.getAttribute("tongtien");
			khachhang kh= (khachhang) session.getAttribute("kh");
			if(kh==null) {
				request.setAttribute("loiDathang", "Quý khách chưa đăng nhập");
				request.getRequestDispatcher("loadCart").forward(request, response);
			}
			else if(tongtien>kh.getTienconlai()) {
				request.setAttribute("loiDathang", "Quý khách không đủ tiền vui lòng nạp thêm để đặt hàng");
				request.getRequestDispatcher("loadCart").forward(request, response);
			}
			else {
			ArrayList<cartOrder> cartOrders= (ArrayList<cartOrder>) session.getAttribute("listCart");
			DAO dao = new DAO();
			if(cartOrders.size()==0) {
				request.setAttribute("loiDathang", "Giỏ hàng trống");
				request.getRequestDispatcher("loadCart").forward(request, response);
			}
			else { boolean kt = dao.insertDonHang(kh.getMakh(),cartOrders);
			if(kt) {
				session.removeAttribute("listCart");
				Long tienconlai= kh.getTienconlai()-tongtien;
				dao.changeMoney(tienconlai,kh.getMakh());
				kh.setTienconlai(tienconlai);
				session.removeAttribute("tongtien");
				request.getRequestDispatcher("LoginControl").forward(request, response);
			}else {
				response.sendRedirect("loadCart");
			}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
