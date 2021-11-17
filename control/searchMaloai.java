package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.loaisach;
import entity.sach;

/**
 * Servlet implementation class searchMaloai
 */
@WebServlet("/searchMaloai")
public class searchMaloai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchMaloai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			ArrayList<sach> listSach = new ArrayList<>();
			ArrayList<loaisach> loaiSach = dao.getAllLoai();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maloai = request.getParameter("ml");
			listSach= dao.getSachbyMaloai(maloai);
			request.setAttribute("listSHome", listSach);
			request.setAttribute("loaiSach", loaiSach);
			request.getRequestDispatcher("trangchu.jsp").forward(request, response);
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
