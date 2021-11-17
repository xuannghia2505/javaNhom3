package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.khachhang;

/**
 * Servlet implementation class quantriUser
 */
@WebServlet("/quantriUser")
public class quantriUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quantriUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			ArrayList<khachhang> khachhangs = new ArrayList<>();
			if(request.getParameter("txtTim")!=null) {
				Long makh = Long.parseLong(request.getParameter("txtTim"));
				khachhang kh = dao.getKHbyMakh(makh);
				khachhangs.add(kh);
			}else {
				khachhangs = dao.getAllKhachhang();
			}
			request.setAttribute("listKhachhang", khachhangs);
			request.getRequestDispatcher("quantriUser.jsp").forward(request, response);
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
