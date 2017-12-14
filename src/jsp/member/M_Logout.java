package jsp.member;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

//@WebServlet("*.out")
@WebServlet("/logout")

public class M_Logout extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String currentURL = request.getParameter("CURRENT_URL");
		HttpSession session = request.getSession();
		session.removeAttribute("LOGIN_ID");
		response.sendRedirect(currentURL);
	}
}
