package wiki.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;

public class AdminIndexAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
           String url = "/admin/adminIndex.jsp";		
           request.getRequestDispatcher(url).forward(request, response);

	}

}
