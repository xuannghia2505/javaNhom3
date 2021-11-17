package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.sach;

/**
 * Servlet implementation class loadPageSach
 */
@WebServlet("/loadPageSach")
public class loadPageSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loadPageSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			int page =1;
			if(request.getParameter("soPage")!=null)
				page = Integer.parseInt(request.getParameter("soPage"));
			DAO dao = new DAO();
			ArrayList<sach> listSHome = dao.getSachbyIndex(page);
			PrintWriter out = response.getWriter();
			for(sach sTam: listSHome) {
			out.println("<div class=\"col-12 col-sm-6 col-md-6 aBook\">\r\n"
					+ "                    <img src=\""+sTam.getAnh()+"\" class=\"imageSach\"><br>\r\n"
					+ "					<div class=\"descriptionSach\">\r\n"
					+ "						<button class=\"btn btnBuy\">\r\n"
					+ "						<a href=\"addCartControl?maSach="+sTam.getMasach()+"\">\r\n"
					+ "						<img src=\"image_sach/buynow.jpg\">\r\n"
					+ "						</a>\r\n"
					+ "						</button><br>\r\n"
					+ "			  			"+sTam.getTensach()+"<br>\r\n"
					+ "						Giá bán: "+sTam.getGia()+" $\r\n"
					+ "					\r\n"
					+ "					</div>\r\n"
					+ "                </div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
