package jsp.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class R_AnswerViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String rNum = request.getParameter("rNum");
		C_Dao dao = new C_Dao();
		R_Dto dto = dao.answerView(rNum);
		request.setAttribute("DTO", dto);
	}
}
