package jsp.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import com.mysql.jdbc.StringUtils;

public class C_ListCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		C_Dao dao = new C_Dao();
		String c_Page=(request.getParameter("PAGE_NUM")==null) ? "1" : request.getParameter("PAGE_NUM");
		Page_Dto dto = dao.pazing(Integer.parseInt(c_Page)); 
		ArrayList<C_Dto> dtos = dao.readPage(dto.getRecord_start_num(), dto.getPage_per_record_cnt()/*읽을 시작 인덱스, 읽을 갯수*/);
		if(dtos.size()==0)
			request.setAttribute("DTOS", "EMPTY");
		else
			request.setAttribute("DTOS", dtos);
		request.setAttribute("DTO", dto);
	}
}
