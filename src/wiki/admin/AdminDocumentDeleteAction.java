package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.wiki_adminDAO;

public class AdminDocumentDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WikiServlet?command=admin_document_list";
		wiki_adminDAO wikiadminDAO = wiki_adminDAO.getInstance();
		int no = Integer.parseInt(request.getParameter("wseq"));

			wikiadminDAO.admin_document_delete(no);
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}