package wiki.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiVO.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/adminMemberList.jsp";

		MemberDAO DAO =MemberDAO.getInstance();
		ArrayList<MemberVO> VO=DAO.AdminMemberList();
		request.setAttribute("VO", VO);			
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
