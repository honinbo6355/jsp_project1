package jsp.member;

import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

//@WebServlet("*.in")
@WebServlet("/login")

public class M_Login extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		String currentURL = request.getParameter("CURRENT_URL");
		String result=null;
		if(checkLoginInfo(id, password)){
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_ID", id);
			result = "SUCCESS";
		}else{
			result="FAIL";
		}
		response.sendRedirect("/Local_my_website1/member/m_login_result.jsp?LOGIN_RESULT="+result+"&CURRENT_URL="+currentURL);
	}
	private boolean checkLoginInfo(String id, String password) throws ServletException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		boolean result=false;
		try{
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/mywdbpool");
			conn = ds.getConnection();
			if(conn==null)
				throw new Exception("Error!!");
			sql = "SELECT password FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next())
				return false;
			String correctPassword = rs.getString("password");
			if(password.equals(correctPassword))
				result=true;
			else
				result=false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
}
