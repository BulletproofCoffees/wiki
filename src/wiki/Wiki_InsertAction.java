package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiDAO.WikiDAO;
import wikiVO.MemberVO;
import wikiVO.WikiVO;

public class Wiki_InsertAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String url = "WikiServlet?command=wikiList"; HttpSession session =
		 * request.getSession(); MemberVO loginUser = (MemberVO)
		 * session.getAttribute("loginUser"); int suzeLimit = 5 * 1024 * 1024; String
		 * savePath = "wiki_images"; ServletContext context =
		 * session.getServletContext(); String uploadFilePath =
		 * context.getRealPath(savePath); MultipartRequest multi = new
		 * MultipartRequest(request, uploadFilePath, suzeLimit, "UTF-8", new
		 * DefaultFileRenamePolicy()); WikiDAO wikiDAO = WikiDAO.getInstance(); WikiVO
		 * wikiVO = new WikiVO(); wikiVO.setId(loginUser.getId());
		 * wikiVO.setKind(multi.getParameter("kind"));
		 * wikiVO.setTitle(multi.getParameter("title"));
		 * wikiVO.setContent(multi.getParameter("content"));
		 * wikiVO.setImage(multi.getFilesystemName("image"));
		 * 
		 * System.out.println(multi.getParameter("title"));
		 * System.out.println(multi.getParameter("content"));
		 * 
		 * request.setAttribute("wikiVO", wikiVO); wikiDAO.insertWiki(wikiVO);
		 * response.sendRedirect(url);
		 */
		
		
		String url = "WikiServlet?command=wikiList";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		WikiDAO DAO = WikiDAO.getInstance();
		WikiVO vo = new WikiVO();
		vo.setId(loginUser.getId());
		vo.setTitle(request.getParameter("title"));
		System.out.println(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		String option = request.getParameter("option");

		if (option == null) {
			option = "�ι���";
		} else if (option.equals("�ι���")) {
			option = "�ι���";
		} else if (option.equals("����")) {
			option = "����";
		} else if (option.equals("�̺з�")) {
			option = "�̺з�";
		}

		request.setAttribute("wikiVO", vo);
		DAO.insertWiki(option, vo);
		response.sendRedirect(url);
	}
}
