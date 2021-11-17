package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.khachhang;

/**
 * Servlet implementation class addOrder
 */
@WebServlet("/addOrder")
public class addOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			HttpSession session = request.getSession();
			khachhang kh = (khachhang) session.getAttribute("kh");
			Long makh = (Long) kh.getMakh();
			String hoten =(String) request.getParameter("txtHoten");
			String sdt = (String) request.getParameter("txtSdt");
			String diachi =(String) request.getParameter("txtDiachi");
			
			dao.insertDonhang(makh, hoten, sdt, diachi);
			session.removeAttribute("tongtien");
			session.removeAttribute("listCart");
			response.sendRedirect("loadCart");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
