package wiki.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wiki.forum.wiki_forumDAO;
import wikiDAO.WikiDAO;
import wikiVO.MemberVO;
import wikiVO.WikiVO;
import wikiVO.wiki_forumVO;

public class AdminDocumentListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/admindocumentList.jsp";
		//ï¿½Ë»ï¿½
		String key = request.getParameter("key");
		String option = request.getParameter("option");
		if(option == null) {
			option = "id";
		}else if(option.equals("1")) {
				option = "id";
				System.out.println(option);
		}else if(option.equals("2")) {option = "title";}
		if(key == null) {key = "";}
		
			WikiDAO wikiDAO = WikiDAO.getInstance();
			ArrayList<WikiVO> wikiList = wikiDAO.listWiki(option, key);
			String optionList[] = {"ÀÛ¼ºÀÚ", "¹®¼­¸í"};
			request.setAttribute("optionList", optionList);
			request.setAttribute("wikiList", wikiList);		
			request.getRequestDispatcher(url).forward(request, response);		
	}
	}


