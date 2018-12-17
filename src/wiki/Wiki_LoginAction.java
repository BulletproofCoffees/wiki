package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiVO.MemberVO;

public class Wiki_LoginAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/login/logIn1.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.getPromember(id);
		int result = memberDAO.login(id,pwd);
		//dao로 아이디 중복체크 확인후 
	 	String message = "";
	 	if(result  == -1)
	 	{
	 		System.out.println("아이디오류");
	 		message = "등록되지않은 아이디입니다.";
	 		request.setAttribute("message", message);
	 		url = "/login/logIn.jsp";
	 	}else if(result == 0)
	 	{
	 		
	 		System.out.println("비번오류");
	 		message = "비밀번호가 다릅니다.";
	 		request.setAttribute("message", message);
	 		url = "/login/logIn.jsp";
	 	}
	 	else if(result == 1){
	 		
	 		System.out.println("로그인");	 		
	 		HttpSession session = request.getSession();
	 		session.setAttribute("adminid",id);
	 		session.setAttribute("loginUser", memberVO);
	 		url = "WikiServlet?command=index";
	 	}
		request.getRequestDispatcher(url).forward(request, response);
	}
}