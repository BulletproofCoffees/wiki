package wiki;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;

public class Wiki_ListHAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main/wikiListH.jsp";
		/*HttpSession session = request.getSession();*/
		String key = request.getParameter("key");
		String option = request.getParameter("option");
		if(option == null) {
			option = "id";
		}else if(option.equals("1")) {
				option = "id";
		}else if(option.equals("2")) {
				option = "title";
		}
		if(key == null) {
			key = "";
		}
		System.out.println("��?" + request.getParameter("humanities"));
			WikiDAO wikiDAO = WikiDAO.getInstance();
			ArrayList<WikiVO> wikiList = wikiDAO.listWiki_Humanities(option, key);
			String optionList[] = {"�ۼ���", "����"};
			request.setAttribute("optionList", optionList);
			request.setAttribute("wikiList", wikiList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	
	
}

