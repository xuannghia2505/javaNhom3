package control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAO;

/**
 * Servlet implementation class saveSach
 */
@MultipartConfig
@WebServlet("/saveSach")
public class saveSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "Webcontent/image_sach";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("themSach");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO dao = new DAO();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			       
			String masach =request.getParameter("txtMasach");
			String tensach =request.getParameter("txtTensach");
			Long soluong =Long.parseLong(request.getParameter("txtSoluong"));
			Long gia =Long.parseLong(request.getParameter("txtGia"));
			String maloai =request.getParameter("maloai");
			String sotap =request.getParameter("txtSotap");
			String tacgia =request.getParameter("txtTacgia");

			//xu ly image
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
               fullSavePath = appPath + SAVE_DIRECTORY;
			} else {
               fullSavePath = appPath + "/" + SAVE_DIRECTORY;
			}
			Part part =  request.getPart("txtAnh");
			String realPath = request.getServletContext().getRealPath("/image_sach");
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Paths.get(realPath))) {
				Files.createDirectory(Paths.get(realPath));
			}
			part.write(realPath+"/"+fileName);
			String dtbAnh="image_sach/"+fileName;
			dao.updateSach( tensach, soluong, gia, maloai, sotap, dtbAnh, tacgia,masach);
			response.sendRedirect("quantriSach");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
