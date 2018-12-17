package wiki.forum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiVO.MemberVO;
import wikiVO.wiki_forumVO;

public class wiki_forumAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		 String url = "forum/forumList.jsp";
		 wiki_forumDAO DAO =wiki_forumDAO.getInstance();
			ArrayList<wiki_forumVO> forum = DAO.forumList();
			request.setAttribute("forum", forum);	
			request.setAttribute("loginUser", loginUser);
	request.getRequestDispatcher(url).forward(request, response);

	}

}


