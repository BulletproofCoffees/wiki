package wiki;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;

public class Wiki_DetailAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String url = "/main/wikiDetail.jsp";
		
		String search = request.getParameter("search"); 
		String wseq = request.getParameter("wseq");
		WikiDAO wikiDAO = WikiDAO.getInstance();
         //�˻�
		if(search != null) {
			search = request.getParameter("search").trim();
			System.out.println(search);
			WikiVO searchwiki = wikiDAO.searchWiki(search);
			request.setAttribute("searchwiki", searchwiki);
		}
		//������
		if(wseq != null) {
			wseq = request.getParameter("wseq").trim();
			System.out.println(wseq);
			WikiVO wikiVO = wikiDAO.getWiki(wseq);
			request.setAttribute("wikiVO", wikiVO);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);*/
		
		String url = "";
        WikiDAO wikiDAO = WikiDAO.getInstance();
        String search = request.getParameter("search");
        if(search != null)
        {
            WikiVO searchwiki = wikiDAO.searchWiki(search);
            if(search.equals(searchwiki.getTitle()))
                url = (new StringBuilder("WikiServlet?command=wikiDetail&wseq=")).append(searchwiki.getWseq()).toString();
            request.setAttribute("searchwiki", searchwiki);
        }
        String wseq = request.getParameter("wseq");
        if(wseq != null)
        {
            url = "/main/wikiDetail.jsp";
            wseq = request.getParameter("wseq").trim();
            WikiVO wikiVO = wikiDAO.getWiki(wseq);
            request.setAttribute("wikiVO", wikiVO);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
	}
}