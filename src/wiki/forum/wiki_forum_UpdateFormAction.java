package wiki.forum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;

public class wiki_forum_UpdateFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 String url = "forum/forumUpdate.jsp";		 
		/*	
		 String no = request.getParameter("no").trim();			
		 wiki_forumDAO DAO = wiki_forumDAO.getInstance();
			wiki_forumVO VO = DAO.UpdateForm(no);
			request.setAttribute("wikiVO", VO);*/
			
		request.getRequestDispatcher(url).forward(request, response);
	
	}
	}