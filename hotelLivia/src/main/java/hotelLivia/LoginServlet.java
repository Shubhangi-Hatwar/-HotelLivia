package hotelLivia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		CustBean cb=new LoginDAO().login(req);
		
		if(cb==null)
		{
			pw.print("Invalid user/password");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("cb",cb);
			pw.print("<div align='center' style='background-color:#cccc99; padding:80px; width:800px;'> ");
			pw.print("<h1>welcome "+cb.getfName()+"</h1><br>");
			pw.print("<table  style='width:600px; text-align:center;'");
			pw.print("<tr><td><a href='food.html'><button style='background-color: #4CAF50; color:white;padding: 8px 16px;border-radius: 4px; cursor: pointer;'>Foods</button></a></td>");
			pw.print("<td><a href='rooms.html'><button style='background-color: #4CAF50; color:white;padding: 8px 16px;border-radius: 4px; cursor: pointer;'>Rooms</button></a></td></tr>");
			pw.print("</table></div>");
		}
	}
}



//border: none;

