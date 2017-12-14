package jsp.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C_ContentCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		C_Dao dao = new C_Dao();
		String cId = request.getParameter("cId");
		C_Dto c_dto = dao.contentView(cId);
		ArrayList<R_Dto> dtos = dao.replyView(cId);
		request.setAttribute("C_DTO", c_dto);
		if(dtos.size()==0)
			request.setAttribute("DTOS", "EMPTY");
		else
			request.setAttribute("DTOS", dtos);
	}
}
