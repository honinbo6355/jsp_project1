package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class R_ReplyCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String rGroup = request.getParameter("rGroup");
		String rName = request.getParameter("rName");
		String rContent = request.getParameter("rContent");
		rContent = rContent.replace("\r\n", "<br>");
		C_Dao dao = new C_Dao();
		int result = dao.reply(rGroup, rName, rContent);
		request.setAttribute("CID", rGroup);
		request.setAttribute("RESULT", result);
	}
}
