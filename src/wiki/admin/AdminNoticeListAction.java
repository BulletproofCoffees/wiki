package wiki.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wiki.notice.NoticeDAO;
import wikiVO.NoticeVO;

public class AdminNoticeListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      String url = "admin/adminNoticeList.jsp";
      NoticeDAO DAO =NoticeDAO.getInstance();
		ArrayList<NoticeVO> List=DAO.noticeLest();
		request.setAttribute("List", List);			
		request.getRequestDispatcher(url).forward(request, response);
	}
}
