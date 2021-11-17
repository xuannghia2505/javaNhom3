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
 * Servlet implementation class deleteAll
 */
@WebServlet("/deleteAll")
public class deleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session = request.getSession();
	       session.removeAttribute("listCart");
	       session.removeAttribute("tongtien");
	       response.setCharacterEncoding("utf-8");
		   PrintWriter out =response.getWriter();
		   out.println("<strong id=\"tongtienP\">Tổng cộng:0.0 $</strong>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
