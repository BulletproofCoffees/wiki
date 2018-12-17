package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;

public class AdminLoginFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/adminLogin.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
