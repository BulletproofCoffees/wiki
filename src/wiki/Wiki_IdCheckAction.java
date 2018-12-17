package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;

public class Wiki_IdCheckAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/join/idcheck.jsp";
		String id = request.getParameter("id").trim();
		MemberDAO memberDAO = MemberDAO.getInstance();
		int message = memberDAO.loginMember(request.getParameter("id"));
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
