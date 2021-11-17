package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.ChannelSender;
import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * Servlet implementation class loadPage
 */
@WebServlet("/loadPage")
public class loadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loadPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("soPage"));
		PrintWriter out = response.getWriter();
		String active="";
		out.println("  <li class=\"page-item\" id=\"prePage\">\r\n"
				+ "		      <a class=\"page-link\" onclick=\"prePage('"+page+"')\" tabindex=\"-1\">Previous</a>\r\n"
				+ "		   </li>");
		if(page==1)
		{
			for(int i=page;i<page+6;i++) {
				if(i==page) {
					active="active";
				}else {
					active="";
				}
					
				out.println("<li class=\"page-item "+active+"\" id=\"page"+i+"\">"
					+ "<a class=\"page-link\" onclick=\"loadPageSach('"+i+"')\">"+i+"</a></li>");
			}
		}else if(page==2){
			for(int i=page-1;i<page+5;i++) {
				if(i==page) {
					active="active";
				}else {
					active="";
				}
					
				out.println("<li class=\"page-item "+active+"\" id=\"page"+i+"\">"
					+ "<a class=\"page-link\" onclick=\"loadPageSach('"+i+"')\">"+i+"</a></li>");
			}
		}else {			
		for(int i=page-2;i<page+4;i++) {
			if(i==page) {
				active="active";
			}else {
				active="";
			}
				
			out.println("<li class=\"page-item "+active+"\" id=\"page"+i+"\" >"
				+ "<a class=\"page-link\" onclick=\"loadPageSach('"+i+"')\">"+i+"</a></li>");
		}
		} // else
		out.println("	<li class=\"page-item\" id=\"nextPage\">\r\n"
				+ "		      <a class=\"page-link\" onclick=\"nextPage('"+page+"')\">Next</a>\r\n"
				+ "		    </li>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
