package wiki.baes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.Mybatis.WikiDAO2;
import wiki.forum.wiki_forumDAO;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;
import wikiVO.wiki_forumVO;


@WebServlet("/WikiServlet")
public class WikiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		ActionFactory af = ActionFactory.getlnstance();
		Action action = af.getAction(command);
		if (action != null) {
			action.excute(request, response);			
		}
		/**********************************************************************/
		HttpSession session = request.getSession();
		
		WikiDAO wikiDAO = WikiDAO.getInstance();
		ArrayList<WikiVO> random = wikiDAO.random();
		session.setAttribute("random", random);
		
		

		/*WikiDAO2 wikiDAO2 = WikiDAO2.getInstance();
		ArrayList<WikiVO> wikiList = wikiDAO2.WikiListbar();
		session.setAttribute("List", wikiList);	
		*/
		
		WikiDAO2 wikiDAO2 = WikiDAO2.getInstance();
		List<WikiVO> wikiList = wikiDAO2.WikiListbar();
		session.setAttribute("List", wikiList);	
		
		
		
		
		wiki_forumDAO DAO =wiki_forumDAO.getInstance();		
		ArrayList<wiki_forumVO> forum=DAO.forumListbar();
		session.setAttribute("forumList", forum);
		/**********************************************************************/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
