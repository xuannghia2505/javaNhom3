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
import entity.ChiTietHoaDon;
import entity.khachhang;

/**
 * Servlet implementation class lsmuahangControl
 */
@WebServlet("/lsmuahangControl")
public class lsmuahangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public lsmuahangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DAO dao =new DAO();
			HttpSession session = request.getSession();
			khachhang kh= (khachhang) session.getAttribute("kh");
			ArrayList<ChiTietHoaDon> lsmuahang= dao.getlsMuahangById(kh.getMakh());
			request.setAttribute("lsmuahang", lsmuahang);
			request.getRequestDispatcher("lichsumuahang.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
