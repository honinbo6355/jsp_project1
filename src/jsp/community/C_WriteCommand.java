package jsp.community;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.*;
import java.util.Calendar;
public class C_WriteCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String cName = request.getParameter("cName");
		String cTitle = request.getParameter("cTitle");
		String cContent = request.getParameter("cContent");
		cContent = cContent.replace("\r\n", "<br>");
		C_Dao dao = new C_Dao();
		int result = dao.write(cName,cTitle,cContent);
		request.setAttribute("RESULT", result);
	}
}
