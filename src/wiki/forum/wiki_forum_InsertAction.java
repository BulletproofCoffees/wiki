
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

public class wiki_forum_InsertAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		String url = "WikiServlet?command=wiki_forum";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser == null) {
		url = "WikiServlet?command=login_form";
		}else {
		wiki_forumVO forumVO = new wiki_forumVO();		
		wiki_forumDAO forumDAO = wiki_forumDAO.getInstance();
		ArrayList<wiki_forumVO> forum = forumDAO.forumList();
		forumVO.setId(loginUser.getId());
		forumVO.setTitle(request.getParameter("title"));
		forumVO.setText(request.getParameter("text"));
		request.setAttribute("forum", forum);
		forumDAO.ForumInsert(forumVO);
		}
		response.sendRedirect(url);
	}
}
