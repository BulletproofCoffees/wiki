package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiVO.MemberVO;

public class AdminMemberDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "WikiServlet?command=admin_member_list";
		MemberDAO DAO = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id")); //형변환***	
		System.out.println("회원"+request.getParameter("id")+"삭제");
		DAO.delete(vo);		
		response.sendRedirect(url);
		
		
		
		
		
	}
}
