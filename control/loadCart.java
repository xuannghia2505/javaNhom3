package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loadCart
 */
@WebServlet("/loadCart")
public class loadCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loadCart() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			long tongtien = 0;
			if(session.getAttribute("tongtien")==null)
				session.setAttribute("tongtien", tongtien);
			
			
			request.getRequestDispatcher("giohang.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
