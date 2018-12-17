package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;

public class Wiki_mypageUpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WikiServlet?command=login";
		  String id =request.getParameter("id");
		  String id2 = request.getParameter("idupdate");
		  String email = request.getParameter("emailupdate");
		  String pwd = request.getParameter("pwdupdate");
		  System.out.println(request.getParameter("idupdate"));
	      MemberDAO wikiDAO = MemberDAO.getInstance();
	      wikiDAO.updateMember(email, id2 ,id, pwd);
	      		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
