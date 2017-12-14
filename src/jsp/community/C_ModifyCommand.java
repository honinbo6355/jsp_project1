package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C_ModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		C_Dao dao = new C_Dao();
		String cId = request.getParameter("cId");
		String cTitle = request.getParameter("cTitle");
		String cContent = request.getParameter("cContent");
		cContent = cContent.replace("\r\n", "<br>");
		int result = dao.modify(cId,cTitle,cContent);
		request.setAttribute("RESULT", result);
		request.setAttribute("CID", cId);
	}
}
