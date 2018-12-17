package wiki;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wiki.forum.wiki_forumDAO;
import wiki.notice.NoticeDAO;
import wikiDAO.WikiDAO;
import wikiVO.NoticeVO;
import wikiVO.WikiVO;
import wikiVO.wiki_forumVO;

public class Wiki_IndexAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		
		HttpSession session = request.getSession();
				
		WikiDAO wikiDAO = WikiDAO.getInstance();
		ArrayList<WikiVO> count = wikiDAO.count();
		session.setAttribute("count", count);
		
		NoticeDAO noticeDAO =NoticeDAO.getInstance();
        ArrayList<NoticeVO> noticeList = noticeDAO.ImdexLest();
        request.setAttribute("noticeList", noticeList); 
        
        InetAddress local = InetAddress.getLocalHost();        
        System.out.println("ip: "+local.getHostAddress());	
           
		request.getRequestDispatcher(url).forward(request, response);

	}
	 
   
}
