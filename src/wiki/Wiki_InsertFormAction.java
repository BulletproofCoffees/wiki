package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiVO.MemberVO;

public class Wiki_InsertFormAction implements Action{
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	String url = "/main/wikiInsert_form.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
		url = "WikiServlet?command=login_form";
		}else {
		String kindList[] = {"인문학", "과학", "미분류"};
		request.setAttribute("kindList", kindList);}
		request.getRequestDispatcher(url).forward(request, response);*/
		
		String url = "/main/wikiInsert_form.jsp";
		HttpSession session = request.getSession();
		if(request.getParameter("search") != null) {
			
			String search = request.getParameter("search");
			request.setAttribute("search", search);
		}
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
		url = "WikiServlet?command=login_form";
		}else {
		String kindList[] = {"인문학", "과학", "미분류"};
		request.setAttribute("kindList", kindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
