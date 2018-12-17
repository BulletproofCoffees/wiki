package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiVO.MemberVO;

public class Wiki_mypageAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/my.jsp";
		
	  	
	      MemberDAO wikiDAO = MemberDAO.getInstance();
	      MemberVO memberVO = wikiDAO.getPromember(request.getParameter("id"));
	      
	      
			request.setAttribute("memberVO", memberVO);			
			request.getRequestDispatcher(url).forward(request, response);
	}

}
