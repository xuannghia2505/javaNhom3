package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class datHang
 */
@WebServlet("/datHang")
public class datHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public datHang() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(" <form action=\"addOrder\"  method=\"post\" style=\"margin-bottom: 50px;\">\r\n"
				+ "    Nhập thông tin của bạn:<br>\r\n"
				+ "    Họ Tên: <input type=\"text\" class=\"form-control\" name=\"txtHoten\"> <br>\r\n"
				+ "    SDT: <input type=\"text\" class=\"form-control\" name=\"txtSdt\"> <br>\r\n"
				+ "    Địa chỉ: <input type=\"text\" class=\"form-control\" name=\"txtDiachi\"> <br>\r\n"
				+ "    <input type=\"submit\" value=\"Đặt hàng\" class=\"btn btn-success \">\r\n"
				+ "    </form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
