package hotelLivia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/bill")
public class BillServlet extends HttpServlet
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
			ArrayList<String> al=(ArrayList<String>)hs.getAttribute("al");
			CustBean cb=(CustBean)hs.getAttribute("cb");
			pw.print("<h1 align='center'>Hotel Livia</h1>");
			pw.print("Name: "+cb.getfName());
			pw.print("<br>PhoneNumber: "+cb.getPhNo()+"<br></hr><div align='center' style='background-color:#99ccff;width: 900px; padding:50px;'> "
					+ "<table style='width:700px; text-align:center;'>");
			pw.print("<tr><th>Sl</th><th>Item</th><th>price</th><th>Qnty</th><th>Bill</th></tr>");
			int i=1,tbill=0;
			for(String k:al)
			{
				if(k.equals("lolly"))	//<td></td>
				{
					int pc=160,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Chicken lollypop</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("crispy"))
				{
					int pc=180,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Crispy Chicken</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("manchu"))
				{
					int pc=140,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Chicken manchuria</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("cButter"))
				{
					int pc=160,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Chicken Butter Masala</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("cBiryani"))
				{
					int pc=190,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Chicken Biryani</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("mBiryani"))
				{
					int pc=210,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Mutton Biryani</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("ice"))
				{
					int pc=60,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt; tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Fried Ice Creame</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("gulab"))
				{
					int pc=50,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>Hot Gulab Jamun</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				else if(k.equals("double"))
				{
					int pc=70,qnt=Integer.parseInt(req.getParameter(k)),bill=pc*qnt;tbill+=bill;
					
					pw.print("<tr><td>"+i+"</td><td>double ka meeta</td><td>"+pc+"</td><td>"+qnt+"</td><td>"+bill+"</td></tr>");
				}
				i++;
			}
			pw.print("</table><hr>Total="+tbill);
			
			ServletContext sc=this.getServletContext();
			RBean rb=(RBean)sc.getAttribute("rbill");
			if(rb!=null)
			{
				long rBill=rb.getrBill();
				pw.print("<br>Rooms Bill ="+rBill);
				pw.print("<br><br>Total Bill ="+(tbill+rBill));
				rb=null;
				sc.removeAttribute("rbill");
			}
			
//			Cookie c[]=req.getCookies();
//			pw.print(" <br>lendgth "+c.length);
//			if(c.length>0)
//			{
//				pw.print("<br>room="+c[0].getValue());
//				long rBill=Long.parseLong(c[0].getValue());
//				pw.print("<br>Rooms Bills :"+rBill);
//				pw.print("<br>Total :"+(rBill+tbill));
//				pw.print("</div>");
//			}
		}
	}
}
