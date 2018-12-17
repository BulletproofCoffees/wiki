package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;

public class Wiki_LogoutAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "WikiServlet?command=index";
		HttpSession session = request.getSession();
		session.invalidate();		
		request.getRequestDispatcher(url).forward(request, response);
	}
}


