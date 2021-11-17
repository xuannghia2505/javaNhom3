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

import org.apache.jasper.tagplugins.jstl.core.If;
import org.w3c.dom.ls.LSOutput;

import dao.DAO;
import entity.cartOrder;

/**
 * Servlet implementation class changeSoluongP
 */
@WebServlet("/changeSoluongP")
public class changeSoluongP extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public changeSoluongP() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
       
		List<cartOrder> listCO= (List<cartOrder>) session.getAttribute("listCart");
		
		int soP = Integer.parseInt(request.getParameter("soP"));
		String maSp =  request.getParameter("maSp");
		PrintWriter out = response.getWriter();   
		int dem=0;
	    for (cartOrder o : listCO) {   
	       if(o.getMaSP().contains(maSp)) {	
	    	   if(soP==0) {
	    		   listCO.remove(dem);
	    		   out.println("");
	    	   }		
	    	   else{   		   
	    		    o.setSoluong(soP);		  
	    		    System.out.print(o.getSoluong());
       				out.println("<input id =\"soluongP${o.getMaSP() }\" type=\"text\" name=\"txtsl\" value="+soP+" style=\"width:40px\">");  
       				
	    	   }
	    	   break;
	       	}
	    	else {
	       		dem++; 
	       	}       	
	    }
	    session.setAttribute("listCart", listCO);
	
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
