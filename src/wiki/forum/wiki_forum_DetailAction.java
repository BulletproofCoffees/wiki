package wiki.forum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiVO.CommentVO;
import wikiVO.MemberVO;
import wikiVO.wiki_forumVO;

public class wiki_forum_DetailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 String url = "forum/forumDetail.jsp";
			HttpSession session = request.getSession();
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			wiki_forumDAO forumDAO = wiki_forumDAO.getInstance();
			
		 if(request.getParameter("commen") == null) {
			 int no = Integer.parseInt(request.getParameter("no"));
			 int nno = Integer.parseInt(request.getParameter("no"));
			 wiki_forumVO VO = forumDAO.forumDetail(no);
			 
				if(request.getParameter("no1") != null) {
					int no1 = Integer.parseInt(request.getParameter("no1"));
					forumDAO.deleteComment(no1);
				}
				
			 request.setAttribute("Detail", VO);
				ArrayList<CommentVO> commentList = forumDAO.commenList(nno);
				request.setAttribute("commentList", commentList);
		 }else {
				CommentVO commentVO = new CommentVO();		
				wiki_forumVO VO = new wiki_forumVO();
				commentVO.setId(loginUser.getId());
				commentVO.setTitle(request.getParameter("title"));
				commentVO.setText(request.getParameter("text"));
				commentVO.setCommen(request.getParameter("result"));
				String comment = forumDAO.Comment(commentVO , loginUser.getId(), request.getParameter("no"));
				int nno = Integer.parseInt(request.getParameter("no"));
				VO = forumDAO.forumDetail(Integer.parseInt(request.getParameter("no")));
				ArrayList<CommentVO> commentList = forumDAO.commenList(nno);
				
				if(request.getParameter("no1") != null) {
					int no1 = Integer.parseInt(request.getParameter("no1"));
					forumDAO.deleteComment(no1);
				}
				
				request.setAttribute("Detail", VO);
				request.setAttribute("commentList", commentList);
				request.setAttribute("commentVO", commentVO);
				request.setAttribute("comment", comment);
				request.setAttribute("loginUser", loginUser);
		 }
			request.getRequestDispatcher(url).forward(request, response);
		}
	}