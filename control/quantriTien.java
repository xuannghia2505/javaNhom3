package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.lichsuruttien;

/**
 * Servlet implementation class quantriTien
 */
@WebServlet("/quantriTien")
public class quantriTien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quantriTien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			ArrayList<lichsuruttien> listLS = new ArrayList<>();
			
			if(request.getParameter("txtTim")!=null) {
				long key = Long.parseLong(request.getParameter("txtTim"));
				listLS = dao.getLsruttienbyMakh(key);
			}else {
				listLS = dao.getLsruttien();
			}
			
			request.setAttribute("listLS", listLS);
			request.getRequestDispatcher("quantriTien.jsp").forward(request, response);
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
