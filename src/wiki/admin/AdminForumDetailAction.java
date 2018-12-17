package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wiki.forum.wiki_forumDAO;
import wikiVO.wiki_forumVO;

public class AdminForumDetailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String url = "admin/adminforumDetail.jsp";
	        wiki_forumDAO DAO = wiki_forumDAO.getInstance();
	        int no = Integer.parseInt(request.getParameter("no").trim());
	        System.out.println(no);
	        wikiVO.wiki_forumVO VO = DAO.forumDetail(no);
	        request.setAttribute("Detail", VO);
	        request.getRequestDispatcher(url).forward(request, response);
	}

}
