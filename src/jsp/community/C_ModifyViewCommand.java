package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C_ModifyViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		C_Dao dao = new C_Dao();
		String cId = request.getParameter("cId");
		C_Dto dto = dao.modifyView(cId);
		request.setAttribute("DTO", dto);
	}
}
