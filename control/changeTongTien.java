package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.cartOrder;

/**
 * Servlet implementation class changeTongTien
 */
@WebServlet("/changeTongTien")
public class changeTongTien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public changeTongTien() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		long tongtien=(long) session.getAttribute("tongtien");
		List<cartOrder> listCO= (List<cartOrder>) session.getAttribute("listCart");
		int soP = Integer.parseInt(request.getParameter("soP"));
		String maSp = request.getParameter("maSp");
		
		for(cartOrder o : listCO) {
			  if(o.getMaSP().contains(maSp)) {	
				  tongtien+=o.getGia()*(soP-o.getSoluong());
			  }
		}
		PrintWriter out = response.getWriter();   
		out.println("<strong id=\"tongtienP\">Tổng cộng:"+tongtien+"$</strong>");
		 
		session.setAttribute("tongtien", tongtien);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
