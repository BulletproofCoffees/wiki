package wiki.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wiki.forum.wiki_forumDAO;
import wikiVO.wiki_forumVO;


public class AdminForumListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/adminForumList.jsp";		
		 wiki_forumDAO DAO =wiki_forumDAO.getInstance();
			ArrayList<wiki_forumVO> forum=DAO.forumList();
			request.setAttribute("forum", forum);			
			request.getRequestDispatcher(url).forward(request, response);
	}

}
