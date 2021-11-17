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
import entity.sach;

/**
 * Servlet implementation class addCartControl
 */
@WebServlet("/addCartControl")
public class addCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession();
			DAO dao = new DAO();
			long tongtien = 0;
			if(session.getAttribute("tongtien")!=null) {
				tongtien=(long) session.getAttribute("tongtien");
			}
			String masach = (String) request.getParameter("maSach");
			sach s =  dao.getSachbyMasach(masach);
			
			ArrayList<cartOrder> cartOrders = (ArrayList<cartOrder>) session.getAttribute("listCart");
			
			
			if(cartOrders==null) {
				cartOrders = new ArrayList<>();
				cartOrder cartOrder = new cartOrder(s.getMasach(),s.getTensach(),s.getAnh(),s.getGia(),1);
				tongtien=cartOrder.getGia();
				cartOrders.add(cartOrder);
			}
			else {	
				boolean dathem = false;
				for(int i=0 ;i<cartOrders.size();i++) {
					if(cartOrders.get(i).getMaSP().contains(masach)) {
						cartOrders.get(i).setSoluong(cartOrders.get(i).getSoluong()+1);
						tongtien+=cartOrders.get(i).getGia();
						dathem=true;
						break;
					}
				}
				if(dathem==false){
					cartOrder cartOrder = new cartOrder(s.getMasach(),s.getTensach(),s.getAnh(),s.getGia(),1);
					tongtien+=cartOrder.getGia();
					cartOrders.add(cartOrder);
				}
			}
		
			
			session.setAttribute("listCart", cartOrders);
			session.setAttribute("tongtien", tongtien);
			response.sendRedirect("loadCart");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
