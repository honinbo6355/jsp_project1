package jsp.community;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("*.do")

public class C_FrontController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("doGet");
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("doPost");		
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("actionDo");
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage=null;
		Command command=null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String Path=null;
		
		if(com.equals("/community/c_list.do")){
		//	System.out.println("uri : " + uri);
		//	System.out.println("conPath: " + conPath);
		//	System.out.println("com : " + com);
			command = new C_ListCommand();
			command.execute(request, response);
			viewPage="c_list_view.jsp";
		}
		else if(com.equals("/community/c_write_view.do")){
			viewPage="c_write_view.jsp";
		}
		else if(com.equals("/community/c_write.do")){
			command = new C_WriteCommand();
			command.execute(request, response);
			viewPage="c_write_result.jsp";
		}
		
		else if(com.equals("/community/c_content_view.do")){
			command = new C_ContentCommand();
			command.execute(request, response);
			viewPage="c_content_view.jsp";
		}
		
		else if(com.equals("/community/c_modify_view.do")){
			command = new C_ModifyViewCommand();
			command.execute(request, response);
			viewPage="c_modify_view.jsp";
		}
		
		else if(com.equals("/community/c_modify.do")){
			command = new C_ModifyCommand();
			command.execute(request, response);
			viewPage="c_modify_result.jsp";
		}
		else if(com.equals("/community/c_delete.do")){
			command = new C_DeleteCommand();
			command.execute(request, response);
			viewPage="c_delete_result.jsp";
		}
		else if(com.equals("/community/r_reply.do")){
			command = new R_ReplyCommand();
			command.execute(request, response);
			viewPage="r_reply_result.jsp";
		}
		else if(com.equals("/community/r_answer_view.do")){
			command = new R_AnswerViewCommand();
			command.execute(request, response);
			viewPage="r_answer_view_forward.jsp";
		}
		
		else if(com.equals("/community/r_answer.do")){
			command = new R_AnswerCommand();
			command.execute(request, response);
			viewPage="r_answer_result.jsp";
		}
		
		System.out.println("uri : " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com : " + com);
		if(viewPage.contains(".do"))
			Path=viewPage;
		else
			Path="community.jsp?BODY_PATH="+viewPage;
		//RequestDispatcher dispatcher = request.getRequestDispatcher("community.jsp?BODY_PATH="+viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Path);
		dispatcher.forward(request, response);
	}
}
