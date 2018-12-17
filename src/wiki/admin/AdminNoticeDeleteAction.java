package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wiki.notice.NoticeDAO;
import wikiVO.NoticeVO;

public class AdminNoticeDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WikiServlet?command=admin_notice_list";
		NoticeDAO DAO = NoticeDAO.getInstance();
		NoticeVO vo = new NoticeVO();
		
		vo.setNo(Integer.parseInt(request.getParameter("no"))); //형변환***	
		System.out.println(request.getParameter("no")+"삭제");
		DAO.Delete(vo);		
		response.sendRedirect(url);

	}

}
