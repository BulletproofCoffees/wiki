package wiki.forum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;

public class wiki_forum_UpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		String url = "";
		
		/*HttpSession session = request.getSession();		
		wiki_forumVO VO = new wiki_forumVO();		
		VO.setId(request.getParameter("id"));
		VO.setTitle(request.getParameter("title"));
		VO.setText(request.getParameter("text"));
		
		session.setAttribute("id", request.getParameter("id"));
		wiki_forumDAO DAO = wiki_forumDAO.getInstance();
		DAO.ForumUpdate(VO);
		*/
		request.getRequestDispatcher(url).forward(request, response);

	}
}
