package wiki;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiVO.MemberVO;

public class Wiki_JoinAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/join/joinsuccess.jsp";
		/*HttpSession session = request.getSession();*/
		MemberVO memberVO = new MemberVO();
		memberVO.setId(request.getParameter("id"));
		memberVO.setPwd(request.getParameter("pwd"));
		memberVO.setEmail(request.getParameter("email"));
		/*session.setAttribute("id", request.getParameter("id"));*/
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.insertMember(memberVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
