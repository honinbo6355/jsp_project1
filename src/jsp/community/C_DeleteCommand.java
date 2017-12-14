package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C_DeleteCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		C_Dao dao = new C_Dao();
		String cId = request.getParameter("cId");
		int result = dao.delete(cId);
		request.setAttribute("RESULT", result);
	}
}
