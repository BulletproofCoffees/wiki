package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.wiki_adminDAO;

public class AdminForumDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WikiServlet?command=admin_forum_list";
		wiki_adminDAO wikiadminDAO = wiki_adminDAO.getInstance();
		int no = Integer.parseInt(request.getParameter("no"));

			wikiadminDAO.admin_forum_delete(no);
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
