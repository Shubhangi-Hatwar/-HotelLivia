package hotelLivia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
@WebServlet("/rooms")
public class RoomServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		
		
		if(hs==null)
		{
			pw.print("<br>Sesion Expired....");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			CustBean cb=(CustBean)hs.getAttribute("cb");
			ArrayList<String> al2=new ArrayList<String>();
			Enumeration<String> e=req.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				if((req.getParameter(name)!=""))
				{
					al2.add(name);	
				}
				
			}
			hs.setAttribute("al2", al2);
			RequestDispatcher rd=req.getRequestDispatcher("billR");
			rd.include(req, res);
		}
	}
}
