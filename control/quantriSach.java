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
import entity.sach;

/**
 * Servlet implementation class quantriSach
 */
@WebServlet("/quantriSach")
public class quantriSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quantriSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			ArrayList<sach> sachs = new ArrayList<>();
			sachs = dao.getAllsach();
			if(request.getParameter("txtTim")!=null) {
				String tensach = request.getParameter("txtTim");
				sachs=dao.getSachbyTensach(tensach);
			}else {
				sachs = dao.getAllsach();
			}
			request.setAttribute("listSach", sachs);
			request.getRequestDispatcher("quantriSach.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
