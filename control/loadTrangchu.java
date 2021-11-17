package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.khachhang;
import entity.loaisach;
import entity.sach;

/**
 * Servlet implementation class loadTrangchu
 */
@WebServlet("/loadTrangchu")
public class loadTrangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loadTrangchu() {
        super();   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			int tongSach = dao.tongSach();		
			int soTrang = tongSach/6;
			if(tongSach%6!=0)
				soTrang+=1;
			int trangDau = 1;
			int trangCuoi = trangDau+5;
			if(trangCuoi>soTrang)
				trangCuoi=soTrang;
			ArrayList<sach> listSach = dao.getSachbyIndex(trangDau);
			ArrayList<loaisach> loaiSach = dao.getAllLoai();
			request.setAttribute("listSHome", listSach);
			request.setAttribute("loaiSach", loaiSach);
			request.setAttribute("trangDau", trangDau);
			request.setAttribute("trangCuoi", trangCuoi);
			request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
