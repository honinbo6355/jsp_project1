package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class R_AnswerCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String rParent = request.getParameter("rParent");
		String rGroup = request.getParameter("rGroup");
		String rName = request.getParameter("rName");
		String rContent = request.getParameter("rContent");
		rContent = rContent.replace("\r\n", "<br>");
		String rStep = request.getParameter("rStep");
		String rIndent = request.getParameter("rIndent");
		
		C_Dao dao = new C_Dao();
		int result = dao.answer(rParent, rGroup, rName, rContent, rStep, rIndent);
		request.setAttribute("RESULT", result);
	}
}
