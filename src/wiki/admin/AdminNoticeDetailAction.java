package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wiki.notice.NoticeDAO;
import wikiVO.NoticeVO;

public class AdminNoticeDetailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String url = "admin/adminNoticeDetail.jsp";
		 
		 String no = request.getParameter("no");
			NoticeDAO DAO = NoticeDAO.getInstance();			
				no = request.getParameter("no").trim();
				System.out.println(no);
				NoticeVO VO = DAO.noticeDetail(no);
				request.setAttribute("Detail", VO);
				
		 request.getRequestDispatcher(url).forward(request, response);
	}

}
