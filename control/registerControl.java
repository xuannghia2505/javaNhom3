package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DAO;
import entity.khachhang;

/**
 * Servlet implementation class registerControl
 */
@WebServlet("/registerControl")
public class registerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public registerControl() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			DAO dao = new DAO();
			String hoten = request.getParameter("txtHoten");
			String diachi = request.getParameter("txtAddress");
			String sdt = request.getParameter("txtSdt");
			String email = request.getParameter("txtEmail");
			String username = request.getParameter("txtUsername");
			String pass = request.getParameter("txtPass");
			String repass = request.getParameter("txtrePass");
			if(request.getAttribute("messenge")!=null) {
				request.setAttribute("messenge", "");
			}
			String messenge = "";
			if(hoten==""||diachi==""||sdt==""||email==""||username==""||pass==""||repass=="") {
				messenge="Không được bỏ trống các trường";
			}
			if(dao.getKHbyUsername(username)!=null) {
				messenge="Tài khoản đã tồn tại";
			}
			if(pass.equals(repass)==false) {
				messenge="Mật khẩu không trùng khớp";
			}
			if(messenge=="") {
				boolean kt = dao.insertKhachHang(hoten, diachi, sdt, email, username, pass);
				if(kt) {
					response.sendRedirect("loadTrangchu");
				}
				else {
					PrintWriter out = response.getWriter();
					out.println("Đăng ký không thành công");
					response.sendRedirect("register.jsp");
					
				}
				
			}
			else {
				request.setAttribute("messenge", messenge);
				request.setAttribute("txtHoten", hoten);
				request.setAttribute("txtAddress", diachi);
				request.setAttribute("txtSdt", sdt);
				request.setAttribute("txtEmail", email);
				request.setAttribute("txtUsername", username);
				request.getRequestDispatcher("register.jsp").forward(request, response);;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
