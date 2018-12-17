package wiki;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;

public class wiki_documentSearchAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/Search/Search.jsp";
        String search = request.getParameter("search");
        WikiDAO wikiDAO = WikiDAO.getInstance();
        if(search != null)
        {
            WikiVO searchwiki = wikiDAO.searchWiki(search);
            if(searchwiki == null) {
            	url = "WikiServlet?command=document_search_form";
            	ArrayList<WikiVO> wikiList = wikiDAO.listWiki_SearchFail(search);
            	request.setAttribute("wikiList", wikiList);
            }else if(search.equals(searchwiki.getTitle())) {
                url = "WikiServlet?command=wikiDetail";
            }                      
            HttpSession session = request.getSession();
	 		session.setAttribute("search", search);
        }
        request.getRequestDispatcher(url).forward(request, response);
    
	}

}
