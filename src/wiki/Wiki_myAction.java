package wiki;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wiki.forum.wiki_forumDAO;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;
import wikiVO.wiki_forumVO;

public class Wiki_myAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/my.jsp";

		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
