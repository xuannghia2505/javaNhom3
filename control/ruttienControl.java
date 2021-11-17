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
 * Servlet implementation class ruttienControl
 */
@WebServlet("/ruttienControl")
public class ruttienControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ruttienControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();			
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			long sotienrut = Long.parseLong(request.getParameter("txtSotienrut"));
			khachhang kh= (khachhang) session.getAttribute("kh");
			DAO dao = new DAO();
			if(sotienrut<1) {
				request.setAttribute("messengeRuttien", "Số tiền rút phải lớn hơn 0!");
			}
			else if(sotienrut>kh.getTienconlai()) {
				request.setAttribute("messengeRuttien", "Số tiền rút vượt quá tiền hiện có!");
			}else {
				kh.setTienconlai(kh.getTienconlai()-sotienrut);
				dao.changeMoney(kh.getTienconlai(),kh.getMakh());
				dao.insertLsRutTien(kh.getMakh(), sotienrut);				
				request.setAttribute("messengeRuttien", "Rút tiền thành công, phía nhà sách sẽ xử lý sớm nhất có thể!");
			}
			request.getRequestDispatcher("ruttien.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
