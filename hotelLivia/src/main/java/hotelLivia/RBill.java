package hotelLivia;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/billR")
public class RBill extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.print("<h1>Session Expired...</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			CustBean cb=(CustBean)hs.getAttribute("cb");
			ArrayList<String> al2=(ArrayList<String>)hs.getAttribute("al2");
			pw.print("<h1 align='center'>Hotel Livia</h1>");
			pw.print("Name: "+cb.getfName());
			pw.print("<br>PhoneNumber: "+cb.getPhNo()+"<br></hr><div align='center' style='background-color:#99ccff;width: 900px; padding:50px;'> "
					+ "<table style='width:700px; text-align:center;'>");
			pw.print("<tr><th>Sl</th><th>RoomType</th><th>price</th><th>StartDate</th><th>endDate</th><th>Days</th><th>Bill</th></tr>");
			int i=0;long tBill =0;
			for(String k:al2)
			{
				if(k.equals("sweet1"))
				{
					
					String date1=req.getParameter(k);//2023 07 07
					String date2=req.getParameter("sweet2");//2023-07-09
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=699;long bill=pc*days;tBill+=bill; 
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>sweet room</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				else if(k.equals("acSweet1"))
				{
					
					String date1=req.getParameter(k);
					String date2=req.getParameter("acSweet2");
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=1299;long bill=pc*days;tBill+=bill;
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>sweet room AC</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				
				else if(k.equals("single1"))
				{
					
					String date1=req.getParameter(k);
					String date2=req.getParameter("single2");
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=1299;long bill=pc*days;tBill+=bill; 
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>Deluxe single room</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				
				else if(k.equals("acSingle1"))
				{
					
					String date1=req.getParameter(k);
					String date2=req.getParameter("acSingle2");
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=1999;long bill=pc*days;tBill+=bill; 
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>sweet room AC</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				else if(k.equals("double1"))
				{
					
					String date1=req.getParameter(k);
					String date2=req.getParameter("double2");
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=1999;long bill=pc*days;tBill+=bill; 
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>sweet room AC</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				else if(k.equals("acDouble1"))
				{
					
					String date1=req.getParameter(k);
					String date2=req.getParameter("acDouble2");
					date1=date1.replace('-',' ');
					date2=date2.replace('-',' ');
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
					try {
						Date dt1=myFormat.parse(date1);
						Date dt2=myFormat.parse(date2);
						long diff = dt2.getTime() - dt1.getTime();
						long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(days<0)days=0;
						int pc=2499;long bill=pc*days;tBill+=bill;
						if(days>0)
						{
							i++;
							pw.print("<tr><td>"+i+"</td><td>sweet room AC</td><td>"+pc+"</td><td>"+date1+"</td><td>"+date2+"</td><td>"+days+"</td><td>"+bill+"</td></tr>");
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						pw.print("<h1>Select Corectly...</h1>");
						RequestDispatcher rd=req.getRequestDispatcher("rooms.html");
						rd.include(req, res);
					}
				}
				
			}
			pw.print("</table><hr>Total="+tBill);
			
			RBean rb=new RBean();
			rb.setrBill(tBill);
			ServletContext sc=this.getServletContext();
			sc.setAttribute("rbill", rb);
			
//			Cookie ck=new Cookie("tBill", ""+tBill);
//			res.addCookie(ck);
//			pw.println("<html><body><form>");
//			pw.println("<input type='hidden' name='bill' value='"+tBill+">");
			pw.print("<div align='right'><a href=food.html> Order Food?</a></div></div>");
			//pw.println("</form></body></html>");
		}
	}
}
