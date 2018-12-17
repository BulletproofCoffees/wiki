package wiki;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wiki.baes.Action;
import wikiDAO.WikiDAO;

public class Wiki_UpdateFormAction
    implements Action
{

    public Wiki_UpdateFormAction()
    {
    }

    public void excute(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String url = "/main/wikiUpdate_form.jsp";
        String wseq = request.getParameter("wseq").trim();
        WikiDAO wikiDAO = WikiDAO.getInstance();
        wikiVO.WikiVO wikiVO = wikiDAO.getWiki(wseq);
        request.setAttribute("wikiVO", wikiVO);
        String kindList[] = {
            "인문학", "과학", "미분류"
        };
        request.setAttribute("kindList", kindList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
