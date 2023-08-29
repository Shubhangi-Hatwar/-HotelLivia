package hotelLivia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/food")
public class FoodServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.print("Sesion Expired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ArrayList<String> al=new ArrayList<String>();
			CustBean cb=(CustBean)hs.getAttribute("cb");
			pw.print("hello "+cb.getfName()+"<br>");
			Enumeration<String> e=req.getParameterNames();
			while(e.hasMoreElements())
			{
				String name=e.nextElement();
//				pw.print(req.getParameter(name));
				if(req.getParameter(name)!="" && Integer.parseInt(req.getParameter(name))>0)
				{
					al.add(name);
				}
			}
			hs.setAttribute("al", al);
			RequestDispatcher rd=req.getRequestDispatcher("bill");
			rd.include(req, res);
		}
		
	}
}
